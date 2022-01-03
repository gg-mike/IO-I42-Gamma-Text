package pl.put.poznan.transformer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.exceptions.TextStatisticNotFoundException;
import pl.put.poznan.transformer.models.RequestTextStatistic;
import pl.put.poznan.transformer.models.ResponseTextStatistic;
import pl.put.poznan.transformer.textstatistics.TextStatistic;

import java.util.HashMap;
import java.util.Map;

@Service
public class TextStatisticService {

    @Autowired
    private Map<String, TextStatistic> textStatisticMap;

    public ResponseTextStatistic applyTextStatistics(RequestTextStatistic requestTextStatistic) {
        Map<String, Object> textStatisticList = new HashMap<>();
        for (String statisticName : requestTextStatistic.getTextStatisticsNamesList()) {
            if (!textStatisticMap.containsKey(statisticName)) {
                throw new TextStatisticNotFoundException(statisticName);
            }
            textStatisticList.put(statisticName, textStatisticMap.get(statisticName).applyStatistic(requestTextStatistic.getInputText()));
        }
        return new ResponseTextStatistic(requestTextStatistic.getInputText(), textStatisticList);
    }

}
