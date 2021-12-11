package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Reverse String but preserve the capitalization of letters (indexes of capitalized letters don't change)
 *
 * @author Michał Grygiel
 * @see TextTransformer
 */
@Slf4j
@Component
public class ReverseTextTransformer implements TextTransformer {
    @Override
    public String transform(String text) {
        StringBuilder builder = new StringBuilder(text);
        builder.reverse();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i)))
                builder.setCharAt(i, Character.toUpperCase(builder.charAt(i)));
            else
                builder.setCharAt(i, Character.toLowerCase(builder.charAt(i)));
        }
        return builder.toString();
    }
}
