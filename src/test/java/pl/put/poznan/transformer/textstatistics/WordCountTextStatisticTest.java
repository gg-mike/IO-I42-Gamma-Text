package pl.put.poznan.transformer.textstatistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCountTextStatisticTest {

    private WordCountTextStatistic wordCountTextStatistic;

    @BeforeEach
    public void init() {
        wordCountTextStatistic = new WordCountTextStatistic();
    }

    @Test
    void testApplyStatistic() {
        assertEquals(Map.of(
                "abc", 2L,
                "cba", 3L,
                "aaa", 1L,
                "s", 2L
        ), wordCountTextStatistic.applyStatistic("cba s abc cba cba abc aaa s "));
    }

    @Test
    void testApplyStatisticWhenEmptyText() {
        assertEquals(Map.of(), wordCountTextStatistic.applyStatistic(""));
    }

}
