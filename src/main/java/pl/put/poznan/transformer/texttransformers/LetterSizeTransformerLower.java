package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Zmianać wielkości liter na lower
 *
 * @author Mikalai Chabatarevich
 * @see TextTransformer
 */
@Slf4j
@Component
public class LetterSizeTransformerLower implements TextTransformer {
    public String transform(String text){
        return text.toLowerCase();
    }
}
