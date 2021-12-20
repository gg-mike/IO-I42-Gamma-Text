package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Zmianać wielkości liter na capitalize
 *
 * @author Mikalai Chabatarevich
 * @see TextTransformer
 */
@Slf4j
@Component
public class LetterSizeTransformerCapital implements TextTransformer {
    public String transform(String text){
        String[] words;
        words = text.split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            String resultWord = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            result.append(resultWord);
            if (i + 1 < words.length)
                result.append(" ");
        }
    return result.toString();
    }
}
