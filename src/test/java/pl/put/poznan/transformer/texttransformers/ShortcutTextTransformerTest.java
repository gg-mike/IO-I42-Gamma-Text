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
class ShortcutTextTransformerTest {

    private ShortcutTextTransformer shortcutTextTransformer;

    @BeforeEach
    public void init() {
        shortcutTextTransformer = new ShortcutTextTransformer();
    }

    @Test
    void testApplyTransform() {
        Iterator<Pair<String>> itr = mock(Iterator.class);
        Mockito.when(itr.hasNext()).thenReturn(true, false);
        Mockito.when(itr.next()).thenReturn(new Pair<>("prof. ", "profesor "));


        List<Pair<String>> pairMap = mock(List.class);
        Mockito.when(pairMap.iterator()).thenReturn(itr);

        shortcutTextTransformer.setShortcuts(pairMap);

        assertEquals("profesor ",
                shortcutTextTransformer.transform("prof. "));
    }

    @Test
    void testApplyTransformWhenNotFoundTransform() {
        Iterator<Pair<String>> itr = mock(Iterator.class);
        Mockito.when(itr.hasNext()).thenReturn(true, false);
        Mockito.when(itr.next()).thenReturn(new Pair<>("prof. ", "profesor "));


        List<Pair<String>> pairMap = mock(List.class);
        Mockito.when(pairMap.iterator()).thenReturn(itr);

        shortcutTextTransformer.setShortcuts(pairMap);

        assertEquals("abc",
                shortcutTextTransformer.transform("abc"));
    }

    @Test
    void testApplyTransformWhenEmpty() {
        Iterator<Pair<String>> itr = mock(Iterator.class);
        Mockito.when(itr.hasNext()).thenReturn(true, false);
        Mockito.when(itr.next()).thenReturn(new Pair<>("abc", "cba"));
        List<Pair<String>> pairMap = mock(List.class);
        Mockito.when(pairMap.iterator()).thenReturn(itr);

        shortcutTextTransformer.setShortcuts(pairMap);

        assertEquals("",
                shortcutTextTransformer.transform(""));
    }

}
