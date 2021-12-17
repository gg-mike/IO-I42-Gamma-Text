package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Map.entry;

/**
 * Changes characters to be compatible with Latex
 *
 * @author Michał Grygiel
 * @see TextTransformer
 */
@Slf4j
@Component
public class LatexTextTransformer implements TextTransformer {
    private final Map<Character, String> specialSymbols = Map.ofEntries(
            entry('%', "\\%"),
            entry('$', "\\$"),
            entry('{', "\\{"),
            entry('}', "\\}"),
            entry('_', "\\_"),
            entry('¶', "\\P"),
            entry('|', "\\textbar"),
            entry('>', "\\textgreater"),
            entry('<', "\\textless"),
            entry('-', "\\textdash"),
            entry('™', "\\testtrademark"),
            entry('¡', "\\texteclamdown"),
            entry('¿', "\\textquestiondown"),
            entry('£', "\\pounds"),
            entry('#', "\\#"),
            entry('&', "\\&"),
            entry('§', "\\S"),
            entry('\\', "\\textbackslash"),
            entry('—', "\\textemdash"),
            entry('®', "\\textregistered"),
            entry('ⓐ', "\\textcircled{a}"),
            entry('©', "\\copyright")
    );

    @Override
    public String transform(String text) {
        log.debug("in  = " + text);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (specialSymbols.containsKey(text.charAt(i)))
                builder.append(specialSymbols.get(text.charAt(i)));
            else
                builder.append(text.charAt(i));
        }
        log.debug("out = " + builder);
        return builder.toString();
    }
}
