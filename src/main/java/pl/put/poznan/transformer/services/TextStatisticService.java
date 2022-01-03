package pl.put.poznan.transformer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.exceptions.TextStatisticNotFoundException;
import pl.put.poznan.transformer.models.RequestTextStatistic;
import pl.put.poznan.transformer.models.ResponseTextStatistic;
import pl.put.poznan.transformer.textstatistics.TextStatistic;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class with text statistics logic
 *
 * @author Piotr Parzysz
 * @see TextStatistic
 * @see RequestTextStatistic
 * @see ResponseTextStatistic
 */
@Service
public class TextStatisticService {

    @Autowired
    private Map<String, TextStatistic> textStatisticMap;

    /**
     * method which performs text statistics logic
     *
     * @param requestTextStatistic input text get statistics and set of text-statistics names
     * @return text and all statistics
     * @throws TextStatisticNotFoundException when list of text-statistics names contains unknown name
     */
    public ResponseTextStatistic applyTextStatistics(RequestTextStatistic requestTextStatistic) throws TextStatisticNotFoundException {
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
