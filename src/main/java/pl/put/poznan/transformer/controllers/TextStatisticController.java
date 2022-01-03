package pl.put.poznan.transformer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.transformer.exceptions.TextStatisticNotFoundException;
import pl.put.poznan.transformer.models.RequestTextStatistic;
import pl.put.poznan.transformer.models.ResponseTextStatistic;
import pl.put.poznan.transformer.services.TextStatisticService;

/**
 * RestController class with text statistics endpoint
 *
 * @author Piotr Parzysz
 * @see TextStatisticService
 */
@Slf4j
@RestController
@RequestMapping("/text-statistic")
public class TextStatisticController {

    @Autowired
    private TextStatisticService textStatisticService;

    /**
     * Text statistics endpoint
     *
     * @param requestTextStatistic request body in json
     * @return ResponseTextStatistic response body in json
     */
    @PostMapping
    public ResponseTextStatistic applyTextStatistics(@RequestBody RequestTextStatistic requestTextStatistic) {
        try {
            return textStatisticService.applyTextStatistics(requestTextStatistic);
        } catch (TextStatisticNotFoundException exception) {
            log.error("TextStatisticNotFoundException: {}", exception.getMessage());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
    }

}
