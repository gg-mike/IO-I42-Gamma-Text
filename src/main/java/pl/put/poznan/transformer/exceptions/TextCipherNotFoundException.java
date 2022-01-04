package pl.put.poznan.transformer.exceptions;

public class TextCipherNotFoundException extends RuntimeException {

    public TextCipherNotFoundException(String textCipherName) {
        super("TextCipher: { " + textCipherName + " } not found");
    }

}
