package pl.put.poznan.transformer.textstatistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LettersCountTextStatisticTest {

    private LettersCountTextStatistic lettersCountTextStatistic;

    @BeforeEach
    public void init() {
        lettersCountTextStatistic = new LettersCountTextStatistic();
    }

    @Test
    void testApplyStatistic() {
        assertEquals(Map.of(
                "A", 5L,
                "B", 2L,
                "C", 1L,
                "G", 3L,
                "$", 2L
        ), lettersCountTextStatistic.applyStatistic("aaa bb C $$ g aAGG"));
    }

    @Test
    void testApplyStatisticWhenEmptyText() {
        assertEquals(Map.of(), lettersCountTextStatistic.applyStatistic(""));
    }

}
