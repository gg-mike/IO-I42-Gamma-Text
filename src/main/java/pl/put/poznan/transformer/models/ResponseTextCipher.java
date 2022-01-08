package pl.put.poznan.transformer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Model for output text ciphers
 *
 * @author Michał Grygiel
 */
@Data
@AllArgsConstructor
public class ResponseTextCipher {

    private String originalText;
    private String cipheredText;

}
