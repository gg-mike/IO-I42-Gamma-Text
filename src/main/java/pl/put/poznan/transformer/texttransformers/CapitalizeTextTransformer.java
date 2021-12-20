package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Capitalize all words
 *
 * @author Mikalai Chabatarevich
 * @see TextTransformer
 */
@Slf4j
@Component
public class CapitalizeTextTransformer implements TextTransformer {

    private String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    @Override
    public String transform(String text){
        log.debug("in  = " + text);
        String[] words = text.split("[ \t]+");
        StringBuilder builder = new StringBuilder(capitalize(words[0]));
        for (int i = 1; i < words.length; i++)
            builder.append(" ").append(capitalize(words[i]));
        log.debug("out = " + builder);
        return builder.toString();
    }
}
