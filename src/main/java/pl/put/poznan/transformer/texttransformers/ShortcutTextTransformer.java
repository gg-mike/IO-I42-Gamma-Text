package pl.put.poznan.transformer.texttransformers;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import pl.put.poznan.transformer.config.YamlPropertySourceFactory;
import pl.put.poznan.transformer.models.Pair;

import java.util.List;


@Data
@Slf4j
@Component
@PropertySource(value = "classpath:shortcuts.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "shortcut-config")
public class ShortcutTextTransformer implements TextTransformer {

    private List<Pair<String>> shortcuts;

    @Override
    public String transform(String text) {
        log.info(String.valueOf(shortcuts.toString()));
        return text;
    }

}
