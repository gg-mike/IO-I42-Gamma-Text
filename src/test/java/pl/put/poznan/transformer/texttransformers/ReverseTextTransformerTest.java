package pl.put.poznan.transformer.texttransformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseTextTransformerTest {
    private ReverseTextTransformer transformer;

    @BeforeEach
    public void init() {
        transformer = new ReverseTextTransformer();
    }

    @Test
    public void testSimpleTransformations() {
        assertEquals("", transformer.transform(""));
        assertEquals(" \t", transformer.transform("\t "));
        assertEquals("TsEt", transformer.transform("TeSt"));
        assertEquals("czaCYAcXa", transformer.transform("axcAYCaZc"));
        assertEquals(".atoK am aLa", transformer.transform("Ala Ma kotA."));
    }

    @Test
    public void testNumberTransformations() {
        assertEquals("1tset", transformer.transform("Test1"));
        assertEquals("20.1", transformer.transform("1.02"));
        assertEquals("20.1-", transformer.transform("-1.02"));
        assertEquals("2-e1", transformer.transform("1e-2"));
        assertEquals("2-e1", transformer.transform("1E-2"));
    }

    @Test
    public void testUnicodeTransformations() {
        assertEquals("ΦΤΞγβα", transformer.transform("\u0391\u0392Γξτφ"));
        assertEquals("ᾺᾼᾌἎϛͽͻϻ", transformer.transform("ϺϽϿϚἆᾄᾳὰ"));
    }
}