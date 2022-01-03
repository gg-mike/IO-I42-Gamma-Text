package pl.put.poznan.transformer.textstatistics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class LettersCountTextStatistic implements TextStatistic {

    @Override
    public Object applyStatistic(String text) {
        return Arrays.stream(text.split(""))
                .map(String::toUpperCase)
                .filter(letter -> !letter.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
