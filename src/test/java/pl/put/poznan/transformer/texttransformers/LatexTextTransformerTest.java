package pl.put.poznan.transformer.texttransformers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LatexTextTransformerTest {

    @Autowired
    private LatexTextTransformer transformer;

    @Test
    public void testTransformation() {
        assertEquals("F\\%4", transformer.transform("F%4"));
        assertEquals("\\{x\\&y\\}\\textgreater\\{x\\textdashy\\}\\textless\\{x\\textbary\\}",
                transformer.transform("{x&y}>{x-y}<{x|y}"));
        assertEquals("\\textbackslash\\textemdash\\_\\textemdash\\_\\textbackslash",
                transformer.transform("\\—_—_\\"));
        assertEquals("\\testtrademark\\textregistered\\textcircled{a}\\copyright",
                transformer.transform("™®ⓐ©"));
        assertEquals("\\P\\texteclamdown\\textquestiondown\\pounds\\#\\S",
                transformer.transform("¶¡¿£#§"));
    }
}
