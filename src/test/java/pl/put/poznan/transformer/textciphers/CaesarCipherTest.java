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
    void simpleCiphering() {
        assertEquals("XYZABCDEFGHIJKLMNOPQRSTUVW", cipher.cipher("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 23));
    }
}