package pl.put.poznan.transformer.textciphers;

/**
 * Interface for TextCipher
 *
 * @author Michał Grygiel
 */
public interface TextCipher {
    /**
     * method used for text ciphering
     *
     * @param text input text
     * @param args arguments needed for encryption
     * @return ciphered text
     */
    String cipher(String text, Object args);
}
