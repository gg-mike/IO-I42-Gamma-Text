package pl.put.poznan.transformer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.exceptions.TextTransformNotFoundException;
import pl.put.poznan.transformer.models.TextTransformModel;
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
     * @param textTransformModel input text to transform and set of text-transforms names
     * @return transformed text and all transformation steps
     * @throws TextTransformNotFoundException when set of text-transforms names contains unknown name
     */
    public TextTransformModel transform(TextTransformModel textTransformModel) throws TextTransformNotFoundException {
        List<TextTransformer> textTransformerList = findTextTransformers(textTransformModel.getTextTransformNamesSet());
        applyTextTransforms(textTransformModel, textTransformerList);
        return textTransformModel;
    }

    private List<TextTransformer> findTextTransformers(Set<String> transformSet) throws TextTransformNotFoundException {
        List<TextTransformer> transformNamesList = new LinkedList<>();
        for (String transformName : transformSet) {
            try {
                Class<?> foundClass = Class.forName(TEXT_TRANSFORMERS_PACKAGE + transformName);
                TextTransformer textTransformer = (TextTransformer) foundClass.getDeclaredConstructor().newInstance();
                transformNamesList.add(textTransformer);
            } catch (ReflectiveOperationException exception) {
                throw new TextTransformNotFoundException(transformName);
            }
        }
        return transformNamesList;

    }

    private void applyTextTransforms(TextTransformModel textTransformModel, List<TextTransformer> textTransformerList) {
        String transformedText = textTransformModel.getInputText();
        List<String> textTransformationsList = new LinkedList<>();
        for (TextTransformer textTransformer : textTransformerList) {
            transformedText = textTransformer.transform(transformedText);
            textTransformationsList.add(transformedText);
        }
        textTransformModel.setTextTransformationsList(textTransformationsList);
        textTransformModel.setTransformedText(transformedText);
    }

}
