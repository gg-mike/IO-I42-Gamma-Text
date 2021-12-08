package pl.put.poznan.transformer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.transformer.exceptions.TextTransformNotFoundException;
import pl.put.poznan.transformer.models.TextTransformModel;
import pl.put.poznan.transformer.services.TextTransformerService;

/**
 * RestController class with text transforming endpoint
 * <p>
 * see also: @see TextTransformerService
 * <p>
 * Author: Piotr Parzsz
 */
@Slf4j
@RestController
@RequestMapping("/text-transform")
public class TextTransformerController {

    @Autowired
    private TextTransformerService textTransformerService;

    /**
     * Text transform endpoint
     * @param textTransformModel request body in json
     * @return TextTransformModel response body in json
     */
    @PostMapping
    public TextTransformModel transform(@RequestBody TextTransformModel textTransformModel) {
        try {
            return textTransformerService.transform(textTransformModel);
        } catch (TextTransformNotFoundException exception) {
            log.info("TransformNotFoundException: {}", exception.getMessage());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
    }

}


