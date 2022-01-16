package pl.put.poznan.transformer.models;

import lombok.Data;

import java.util.List;

/**
 * Model for input text statistics
 *
 * @author Piotr Parzysz
 */
@Data
public class RequestTextStatistic {

    private String inputText;
    private List<String> textStatisticsNamesList;

}
