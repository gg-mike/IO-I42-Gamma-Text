package pl.put.poznan.transformer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.transformer.exceptions.TextSplitterNotFoundException;
import pl.put.poznan.transformer.models.RequestTextSplitter;
import pl.put.poznan.transformer.models.ResponseTextSplitter;
import pl.put.poznan.transformer.services.TextSplitterService;

/**
 * RestController class with text splitter endpoint
 *
 * @author Michał Grygiel
 * @see TextSplitterService
 */
@Slf4j
@RestController
@RequestMapping("/text-splitter")
public class TextSplitterController {

    @Autowired
    private TextSplitterService textSplitterService;

    /**
     * Text splitter endpoint
     *
     * @param requestTextSplitter request body in json
     * @return ResponseTextSplitter response body in json
     */
    @PostMapping
    public ResponseTextSplitter applyTextCiphers(@RequestBody RequestTextSplitter requestTextSplitter) {
        try {
            return textSplitterService.applyTextSplitter(requestTextSplitter);
        } catch (TextSplitterNotFoundException exception) {
            log.error("TextSplitterNotFoundException: {}", exception.getMessage());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
    }
}
