package pl.put.poznan.transformer.models;

import lombok.Data;

import java.util.List;

@Data
public class RequestTextStatistic {

    private String inputText;
    private List<String> textStatisticsNamesList;

}
