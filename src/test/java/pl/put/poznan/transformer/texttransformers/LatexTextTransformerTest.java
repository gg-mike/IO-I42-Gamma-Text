package pl.put.poznan.transformer.texttransformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.put.poznan.transformer.models.Pair;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@SuppressWarnings("unchecked")
class LatexTextTransformerTest {

    private LatexTextTransformer transformer;

    @BeforeEach
    public void init() {
        transformer = new LatexTextTransformer();
    }

    @Test
    void testApplyTransform() {
        Iterator<Pair<String>> itr = mock(Iterator.class);
        Mockito.when(itr.hasNext()).thenReturn(true, false);
        Mockito.when(itr.next()).thenReturn(new Pair<>(">", "\\\\textgreater"));


        List<Pair<String>> pairMap = mock(List.class);
        Mockito.when(pairMap.iterator()).thenReturn(itr);

        transformer.setLatex(pairMap);

        assertEquals("abc\\textgreater\\textgreaterabc",
                transformer.transform("abc>>abc"));
    }

    @Test
    void testApplyTransformWhenNotFoundTransform() {
        Iterator<Pair<String>> itr = mock(Iterator.class);
        Mockito.when(itr.hasNext()).thenReturn(true, false);
        Mockito.when(itr.next()).thenReturn(new Pair<>(">", "\\\\textgreater"));


        List<Pair<String>> pairMap = mock(List.class);
        Mockito.when(pairMap.iterator()).thenReturn(itr);

        transformer.setLatex(pairMap);

        assertEquals("abc123",
                transformer.transform("abc123"));
    }

    @Test
    void testApplyTransformWhenEmpty() {
        Iterator<Pair<String>> itr = mock(Iterator.class);
        Mockito.when(itr.hasNext()).thenReturn(true, false);
        Mockito.when(itr.next()).thenReturn(new Pair<>(">", "\\\\textgreater"));

        List<Pair<String>> pairMap = mock(List.class);
        Mockito.when(pairMap.iterator()).thenReturn(itr);

        transformer.setLatex(pairMap);

        assertEquals("",
                transformer.transform(""));
    }

}
