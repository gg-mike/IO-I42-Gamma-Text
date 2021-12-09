package pl.put.poznan.transformer.models;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

/**
 * Model for input text transformations
 *
 * @author Piotr Parzsz
 */
@Data
@ToString
public class RequestTextTransformModel {

    private String inputText;
    private Set<String> textTransformNamesSet;

}
