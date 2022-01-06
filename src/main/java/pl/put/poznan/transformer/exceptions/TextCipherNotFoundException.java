package pl.put.poznan.transformer.exceptions;

/**
 * Thrown when a particular TextCipher cannot be found.
 *
 * @author Michał Grygiel
 */
public class TextCipherNotFoundException extends RuntimeException {

    /**
     * @param textCipherName name of missing text-cipher
     */
    public TextCipherNotFoundException(String textCipherName) {
        super("TextCipher: { " + textCipherName + " } not found");
    }

}
