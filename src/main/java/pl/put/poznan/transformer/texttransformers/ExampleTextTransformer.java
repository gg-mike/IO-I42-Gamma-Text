package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Example implementation of TextTransformer
 *
 * @author Piotr Parzysz
 * @see TextTransformer
 */
@Slf4j
@Component
public class ExampleTextTransformer implements TextTransformer {

    /**
     * example text transformation
     *
     * @param text input text
     * @return transformed text
     */
    @Override
    public String transform(String text) {
        return "example " + text;
    }

}
