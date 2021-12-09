package pl.put.poznan.transformer.texttransformers;

/**
 * Interface for TextTransformers
 *
 * @author Piotr Parzsz
 */
public interface TextTransformer {

    /**
     * method used for text transforming
     *
     * @param text input text
     * @return transformed text
     */
    String transform(String text);

}
