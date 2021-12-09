package pl.put.poznan.transformer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.exceptions.TextTransformNotFoundException;
import pl.put.poznan.transformer.models.RequestTextTransformModel;
import pl.put.poznan.transformer.models.ResponseTextTransformModel;
import pl.put.poznan.transformer.texttransformers.TextTransformer;

import java.util.LinkedList;
import java.util.Map;

/**
 * Service class with text transforming logic
 *
 * @author Piotr Parzsz
 * @see TextTransformer
 */
@Slf4j
@Service
public class TextTransformerService {

    @Autowired
    private Map<String, TextTransformer> textTransformerMap;

    /**
     * method which performs text transformation logic
     *
     * @param requestTextTransformModel input text to transform and set of text-transforms names
     * @return transformed text and all transformation steps
     * @throws TextTransformNotFoundException when set of text-transforms names contains unknown name
     */
    public ResponseTextTransformModel applyTextTransformations(RequestTextTransformModel requestTextTransformModel) throws TextTransformNotFoundException {
        ResponseTextTransformModel responseTextTransformModel = new ResponseTextTransformModel();
        responseTextTransformModel.setOriginalText(requestTextTransformModel.getInputText());
        responseTextTransformModel.setTextTransformationsList(new LinkedList<>());
        String transformedText = requestTextTransformModel.getInputText();
        for (String transformName : requestTextTransformModel.getTextTransformNamesList()) {
            if (!textTransformerMap.containsKey(transformName)) {
                throw new TextTransformNotFoundException(transformName);
            }
            transformedText = textTransformerMap.get(transformName).transform(transformedText);
            responseTextTransformModel.getTextTransformationsList().add(transformedText);
        }
        responseTextTransformModel.setTransformedText(transformedText);
        return responseTextTransformModel;
    }

}
