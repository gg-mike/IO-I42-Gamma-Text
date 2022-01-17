package pl.put.poznan.transformer.textsplitters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSplitterTest {

    private WordSplitter splitter;

    @BeforeEach
    void init() {
        splitter = new WordSplitter();
    }

    @Test
    void testBasic() {
        assertEquals(List.of(new String[]{"aaa", "bbb", "ccc"}), splitter.split("aaa bbb ccc"));
    }

    @Test
    void testEmptyInput() {
        assertEquals(List.of(new String[]{}), splitter.split(""));
        assertEquals(List.of(new String[]{}), splitter.split("\n\n\n"));
        assertEquals(List.of(new String[]{}), splitter.split("\t\t\t"));
        assertEquals(List.of(new String[]{}), splitter.split("   "));
        assertEquals(List.of(new String[]{}), splitter.split("\n \t "));
    }

    @Test
    void testAdvanced() {
        assertEquals(List.of(new String[]{"a", "b", "dd", "s"}), splitter.split("a    b dd \ts"));
        assertEquals(List.of(new String[]{"a", "b", "c"}), splitter.split("a\n\n\nb\t\n   c"));
    }

}