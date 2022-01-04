package pl.put.poznan.transformer.texttransformers;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import pl.put.poznan.transformer.config.YamlPropertySourceFactory;
import pl.put.poznan.transformer.models.Pair;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Changes characters to be compatible with Latex
 *
 * @author Michał Grygiel
 * @see TextTransformer
 */
@Data
@Slf4j
@Component
@PropertySource(value = "classpath:latex.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "latex-config")
public class LatexTextTransformer implements TextTransformer {

    private List<Pair<String>> latex;

    @Override
    public String transform(String text) {
        log.debug(latex.toString());
        log.debug("in  = " + text);
        for (Pair<String> pair : latex) {
            log.debug("pattern = " + Pattern.quote(pair.getFirst()));
            text = text.replaceAll(Pattern.quote(pair.getFirst()), pair.getSecond());
        }
        log.debug("out = " + text);
        return text;
    }
}
