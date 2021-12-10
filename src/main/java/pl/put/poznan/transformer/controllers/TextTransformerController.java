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
import pl.put.poznan.transformer.models.RequestTextTransformModel;
import pl.put.poznan.transformer.models.ResponseTextTransformModel;
import pl.put.poznan.transformer.services.TextTransformerService;

/**
 * RestController class with text transforming endpoint
 *
 * @author Piotr Parzysz
 * @see TextTransformerService
 */
@Slf4j
@RestController
@RequestMapping("/text-transform")
public class TextTransformerController {

    @Autowired
    private TextTransformerService textTransformerService;

    /**
     * Text transform endpoint
     *
     * @param requestTextTransformModel request body in json
     * @return TextTransformModel response body in json
     */
    @PostMapping
    public ResponseTextTransformModel applyTextTransformations(@RequestBody RequestTextTransformModel requestTextTransformModel) {
        try {
            return textTransformerService.applyTextTransformations(requestTextTransformModel);
        } catch (TextTransformNotFoundException exception) {
            log.error("TransformNotFoundException: {}", exception.getMessage());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
    }

}


