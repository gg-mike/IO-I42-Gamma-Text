package pl.put.poznan.transformer.texttransformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class DeleteAllCharactersTest {

    private DeleteAllCharacters transformer;

    @BeforeEach
    void init() { transformer = new DeleteAllCharacters(); }

    @Test
    void testApplyTransform() {
        Iterator itr = mock(Iterator.class);
        Mockito.when(itr.hasNext()).thenReturn(true, false);
        Mockito.when(itr.next()).thenReturn(":", "");


        String text = mock(String.class);
        Mockito.when(text.iterator()).thenReturn(itr);

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




class DeleteAllCharactersTest {
    private DeleteAllCharacters transformer;

    @BeforeEach
    void init() { transformer = new DeleteAllCharacters(); }

    @Test
    void testDeleteAllTransformation() {
        assertEquals("Only letters, %?&^$@=/.;'``!2+:*-#*() anD= nuMberRs 4452 2 1 009",
                transformer.transform("Only letters 2 anD nuMberRs 4452 2 1 009"));
    }

    @Test
    public void testUnicodeTransformations() {
        assertEquals("ΦΤΞγβα", transformer.transform(""));
        assertEquals("ᾺᾼᾌἎϛͽͻϻ", transformer.transform(""));
    }
}