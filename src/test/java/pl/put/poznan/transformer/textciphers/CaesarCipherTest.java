package pl.put.poznan.transformer.textciphers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherTest {
    private CaesarCipher cipher;

    @BeforeEach
    void init() {
        cipher = new CaesarCipher();
    }

    @Test
    void testSimpleCiphering() {
        assertEquals("XYZABCDEFGHIJKLMNOPQRSTUVW", cipher.cipher("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 23));
    }

    @Test
    void testDifferentCases() {
        assertEquals("XYZABC", cipher.cipher("ABCDEF", 23));
        assertEquals("DeFghI", cipher.cipher("AbCdeF", 3));
        assertEquals("xyzabc", cipher.cipher("abcdef", -3));
    }

    @Test
    void testCipherShift() {
        assertEquals("abc", cipher.cipher("abc", 0));
        assertEquals("abc", cipher.cipher("abc", 26));
        assertEquals("abc", cipher.cipher("abc", -26));
    }
}