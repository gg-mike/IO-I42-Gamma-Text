package pl.put.poznan.transformer.exceptions;

/**
 * Thrown when a particular TextSplitter cannot be found.
 *
 * @author Michał Grygiel
 */
public class TextSplitterNotFoundException extends RuntimeException {

    /**
     * @param textSplitterName name of missing text-splitter
     */
    public TextSplitterNotFoundException(String textSplitterName) {
        super("TextSplitter: { " + textSplitterName + " } not found");
    }

}
