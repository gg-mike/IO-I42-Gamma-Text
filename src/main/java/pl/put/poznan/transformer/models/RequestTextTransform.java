package pl.put.poznan.transformer.models;

import lombok.Data;

import java.util.List;

/**
 * Model for input text transformations
 *
 * @author Piotr Parzysz
 */
@Data
public class RequestTextTransform {

    private String inputText;
    private List<String> textTransformNamesList;

}
