package pl.put.poznan.transformer.models;

import lombok.Data;

/**
 * Model for input text splitters
 *
 * @author Michał Grygiel
 */
@Data
public class RequestTextSplitter {

    private String inputText;
    private String textSplitterName;

}
