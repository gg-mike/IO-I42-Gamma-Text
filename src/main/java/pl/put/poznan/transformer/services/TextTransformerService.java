package pl.put.poznan.transformer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.exceptions.TextTransformNotFoundException;
import pl.put.poznan.transformer.models.RequestTextTransformModel;
import pl.put.poznan.transformer.models.ResponseTextTransformModel;
import pl.put.poznan.transformer.texttransformers.TextTransformer;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Service class with text transforming logic
 *
 * @author Piotr Parzsz
 * @see TextTransformer
 */
@Slf4j
@Service
public class TextTransformerService {

    private static final String TEXT_TRANSFORMERS_PACKAGE = "pl.put.poznan.transformer.texttransformers.";

    /**
     * method which performs text transformation logic
     *
     * @param requestTextTransformModel input text to transform and set of text-transforms names
     * @return transformed text and all transformation steps
     * @throws TextTransformNotFoundException when set of text-transforms names contains unknown name
     */
    public ResponseTextTransformModel transform(RequestTextTransformModel requestTextTransformModel) throws TextTransformNotFoundException {
        List<TextTransformer> textTransformerList = findTextTransformers(requestTextTransformModel.getTextTransformNamesList());
        return applyTextTransforms(requestTextTransformModel, textTransformerList);
    }

    private List<TextTransformer> findTextTransformers(List<String> textTransformList) throws TextTransformNotFoundException {
        List<TextTransformer> transformNamesList = new LinkedList<>();
        for (String transformName : textTransformList) {
            try {
                log.debug("Looking for: {}", transformName);
                Class<?> foundClass = Class.forName(TEXT_TRANSFORMERS_PACKAGE + transformName);
                TextTransformer textTransformer = (TextTransformer) foundClass.getDeclaredConstructor().newInstance();
                transformNamesList.add(textTransformer);
            } catch (ReflectiveOperationException exception) {
                throw new TextTransformNotFoundException(transformName);
            }
        }
        return transformNamesList;
    }

    private ResponseTextTransformModel applyTextTransforms(RequestTextTransformModel requestTextTransformModel, List<TextTransformer> textTransformerList) {
        ResponseTextTransformModel responseTextTransformModel = new ResponseTextTransformModel();
        responseTextTransformModel.setOriginalText(requestTextTransformModel.getInputText());
        responseTextTransformModel.setTextTransformationsList(new LinkedList<>());
        String transformedText = requestTextTransformModel.getInputText();
        for (TextTransformer textTransformer : textTransformerList) {
            transformedText = textTransformer.transform(transformedText);
            responseTextTransformModel.getTextTransformationsList().add(transformedText);
        }
        responseTextTransformModel.setTransformedText(transformedText);
        return responseTextTransformModel;
    }

}
