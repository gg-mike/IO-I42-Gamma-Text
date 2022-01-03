package pl.put.poznan.transformer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.exceptions.TextTransformNotFoundException;
import pl.put.poznan.transformer.models.RequestTextTransform;
import pl.put.poznan.transformer.models.ResponseTextTransform;
import pl.put.poznan.transformer.texttransformers.TextTransformer;

import java.util.LinkedList;
import java.util.Map;

/**
 * Service class with text transforming logic
 *
 * @author Piotr Parzysz
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
     * @param requestTextTransform input text to transform and set of text-transforms names
     * @return transformed text and all transformation steps
     * @throws TextTransformNotFoundException when list of text-transforms names contains unknown name
     */
    public ResponseTextTransform applyTextTransformations(RequestTextTransform requestTextTransform) throws TextTransformNotFoundException {
        ResponseTextTransform responseTextTransform = new ResponseTextTransform();
        responseTextTransform.setOriginalText(requestTextTransform.getInputText());
        responseTextTransform.setTextTransformationsList(new LinkedList<>());
        String transformedText = requestTextTransform.getInputText();
        for (String transformName : requestTextTransform.getTextTransformNamesList()) {
            if (!textTransformerMap.containsKey(transformName)) {
                throw new TextTransformNotFoundException(transformName);
            }
            transformedText = textTransformerMap.get(transformName).transform(transformedText);
            responseTextTransform.getTextTransformationsList().add(transformedText);
        }
        responseTextTransform.setTransformedText(transformedText);
        return responseTextTransform;
    }

}
