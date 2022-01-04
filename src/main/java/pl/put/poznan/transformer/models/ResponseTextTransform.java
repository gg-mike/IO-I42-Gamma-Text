package pl.put.poznan.transformer.models;


import lombok.Data;

import java.util.List;

/**
 * Model for output text transformations
 *
 * @author Piotr Parzysz
 */
@Data
public class ResponseTextTransform {

    private String originalText;
    private String transformedText;
    private List<String> textTransformationsList;

}


