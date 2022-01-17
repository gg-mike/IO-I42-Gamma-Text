package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Deleting all characters
 *
 * @author Mikalai Chabatarevich
 * @see TextTransformer
 */
@Slf4j
@Component
public class DeleteAllCharacters implements TextTransformer {
    @Override
    public String transform(String text){
        return text.replaceAll("[^A-Za-z0-9 ]", "");
    }
}
