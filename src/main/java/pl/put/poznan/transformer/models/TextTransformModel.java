package pl.put.poznan.transformer.models;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Set;

/**
 * Model for input and output text transformations
 *
 * @author Piotr Parzsz
 */
@Data
@ToString
public class TextTransformModel {

    private String inputText;
    private String transformedText;
    private Set<String> textTransformNamesSet;
    private List<String> textTransformationsList;

}
