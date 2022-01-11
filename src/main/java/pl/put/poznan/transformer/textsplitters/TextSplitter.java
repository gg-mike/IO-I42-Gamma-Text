package pl.put.poznan.transformer.textsplitters;

import java.util.List;

/**
 * Interface for TextSplitter
 *
 * @author Michał Grygiel
 */
public interface TextSplitter {
    /**
     * method used for text splitting
     *
     * @param text input text
     * @return split text
     */
    List<String> split(String text);
}
