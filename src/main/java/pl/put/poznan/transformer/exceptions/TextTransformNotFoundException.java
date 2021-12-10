package pl.put.poznan.transformer.exceptions;

/**
 * Thrown when a particular TextTransformer cannot be found.
 *
 * @author Piotr Parzysz
 */
public class TextTransformNotFoundException extends RuntimeException {

    /**
     * @param textTransformerName name of missing text-transformer
     */
    public TextTransformNotFoundException(String textTransformerName) {
        super("TextTransformer: { " + textTransformerName + " } not found");
    }
}
