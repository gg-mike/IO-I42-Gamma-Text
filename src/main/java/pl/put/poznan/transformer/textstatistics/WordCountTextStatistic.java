package pl.put.poznan.transformer.textstatistics;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * word counter
 * count the occurrences of all characters
 *
 * @author Piotr Parzysz
 */
@Component
public class WordCountTextStatistic implements TextStatistic {

    /**
     * text statistic method
     *
     * @param text input text
     * @return map with all found characters occurrence count
     */
    @Override
    public Object applyStatistic(String text) {
        return Arrays.stream(text.split(" "))
                .map(String::toLowerCase)
                .filter(word -> !word.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
