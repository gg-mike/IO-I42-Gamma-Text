package pl.put.poznan.transformer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.transformer.exceptions.TextCipherNotFoundException;
import pl.put.poznan.transformer.models.RequestTextCipher;
import pl.put.poznan.transformer.models.ResponseTextCipher;
import pl.put.poznan.transformer.services.TextCipherService;

/**
 * RestController class with text ciphers endpoint
 *
 * @author Piotr Parzysz
 * @see TextCipherService
 */
@Slf4j
@RestController
@RequestMapping("/text-cipher")
public class TextCipherController {

    @Autowired
    private TextCipherService textCipherService;

    /**
     * Text ciphers endpoint
     *
     * @param requestTextCipher request body in json
     * @return ResponseTextCipher response body in json
     */
    @PostMapping
    public ResponseTextCipher applyTextCiphers(@RequestBody RequestTextCipher requestTextCipher) {
        try {
            return textCipherService.applyTextCiphers(requestTextCipher);
        } catch (TextCipherNotFoundException exception) {
            log.error("TextCipherNotFoundException: {}", exception.getMessage());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        }
    }
}