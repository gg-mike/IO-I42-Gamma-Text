package pl.put.poznan.transformer.textsplitters;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Splitting text by words
 *
 * @author Michał Grygiel
 * @see TextSplitter
 */
@Component
public class WordSplitter implements TextSplitter {

    @Override
    public List<String> split(String text) {
        if (text.equals(""))
            return List.of(new String[]{});
        List<String> results = new ArrayList<>(List.of(text.split("[ \t\n]")));
        results.removeIf(element -> (element.equals("")));
        return results;
    }
}
