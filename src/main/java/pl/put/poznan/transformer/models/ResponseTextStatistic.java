package pl.put.poznan.transformer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * Model for output text statistics
 *
 * @author Piotr Parzysz
 */
@Data
@AllArgsConstructor
public class ResponseTextStatistic {

    private String inputText;
    private Map<String, Object> textStatisticsList;

}
