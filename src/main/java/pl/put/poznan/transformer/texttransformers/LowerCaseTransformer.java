package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Lower case all letters
 *
 * @author Mikalai Chabatarevich
 * @see TextTransformer
 */
@Slf4j
@Component
public class LowerCaseTransformer implements TextTransformer {
    @Override
    public String transform(String text){
        return text.toLowerCase();
    }
}
