package pl.put.poznan.transformer.models;


import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Model for output text transformations
 *
 * @author Piotr Parzysz
 */
@Data
@ToString
public class ResponseTextTransformModel {

    private String originalText;
    private String transformedText;
    private List<String> textTransformationsList;

}


