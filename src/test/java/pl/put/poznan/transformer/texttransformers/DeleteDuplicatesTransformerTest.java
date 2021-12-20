package pl.put.poznan.transformer.texttransformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteDuplicatesTransformerTest {
    private DeleteDuplicatesTransformer transformer;

    @BeforeEach
    void init() { transformer = new DeleteDuplicatesTransformer(); }

    @Test
    void testSimpleTransformation() {
        assertEquals("aaa bb c ddd ee", transformer.transform("aaa bb c c c c ddd ee ee"));
    }

    @Test
    void testDifferentCaseTransformation() {
        assertEquals("aaa bb c ddd eE", transformer.transform("aaa bb c C C c ddd eE Ee"));
    }

    @Test
    void testDifferentSeparatorTransformation() {
        assertEquals("aaa bb c ddd ee", transformer.transform("aaa \tbb c c    c  c ddd ee\t ee"));
    }

    @Test
    void testDifferentCaseAndSeparatorTransformation() {
        assertEquals("aaa bb C ddd eE", transformer.transform("aaa \tbb C c    C  c ddd eE\t Ee"));
    }

}