package pl.put.poznan.transformer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Model for output text splitters
 *
 * @author Michał Grygiel
 */
@Data
@AllArgsConstructor
public class ResponseTextSplitter {

    private String originalText;
    private List<String> splitText;

}
