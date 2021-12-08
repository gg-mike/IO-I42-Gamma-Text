package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;

/**
 * Example implementation of TextTransformer
 *
 * @author Piotr Parzsz
 * @see TextTransformer
 */
@Slf4j
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
