package pl.put.poznan.transformer.texttransformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceNumbersToWordsTest {
    private ReplaceNumbersToWords transformer;

    @BeforeEach
    public void init() {transformer = new ReplaceNumbersToWords();}

    @Test
    void testNumToWordsTransformation() {
        assertEquals("", transformer.transform(""));
    }
}