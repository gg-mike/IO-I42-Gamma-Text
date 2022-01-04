package pl.put.poznan.transformer.textciphers;

import org.springframework.stereotype.Component;

/**
 * Encryption of text using Caesar Cipher
 *
 * @author Michał Grygiel
 * @see TextCipher
 */
@Component
public class CaesarCipher implements TextCipher {

    @Override
    public String cipher(String text, Object args) {
        Integer shift = (Integer) args;
        shift %= 26;
        if (shift < 0)
            shift = 26 + shift;

        StringBuilder builder = new StringBuilder();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
                builder.append((char)(((int)text.charAt(i) + shift - 65) % 26 + 65));
            else
                builder.append((char)(((int)text.charAt(i) + shift - 97) % 26 + 97));
        }
        return builder.toString();
    }
}
