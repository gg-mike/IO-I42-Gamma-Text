package pl.put.poznan.transformer.textstatistics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * letter counter
 * count the occurrences of all characters
 *
 * @author Piotr Parzysz
 */
@Slf4j
@Component
public class LettersCountTextStatistic implements TextStatistic {

    /**
     * text statistic method
     *
     * @param text input text
     * @return map with all found characters occurrence count
     */
    @Override
    public Object applyStatistic(String text) {
        return Arrays.stream(text.split(""))
                .map(String::toUpperCase)
                .filter(letter -> !letter.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
