package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Delete duplicates from text
 *
 * @author Michał Grygiel
 * @see TextTransformer
 */
@Slf4j
@Component
public class DuplicateTextTransformer implements TextTransformer {
    @Override
    public String transform(String text) {
        log.debug("in  = " + text);
        String[] words = text.split("[ \t]+");
        StringBuilder builder = new StringBuilder(words[0]);

        String prev = words[0];
        for (String word : words) {
            if (!(prev).equalsIgnoreCase(word)) {
                prev = word;
                builder.append(" ").append(word);
            }
        }
        log.debug("out = " + builder);
        return builder.toString();
    }
}
