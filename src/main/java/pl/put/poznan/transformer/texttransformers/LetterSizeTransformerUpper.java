package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component

public class LetterSizeTransformerUpper implements TextTransformer {
    public String transform(String text){
        return text.toUpperCase();
    }
}
