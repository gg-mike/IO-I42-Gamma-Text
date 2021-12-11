package pl.put.poznan.transformer.models;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Model for input text transformations
 *
 * @author Piotr Parzysz
 */
@Data
@ToString
public class RequestTextTransformModel {

    private String inputText;
    private List<String> textTransformNamesList;

}
