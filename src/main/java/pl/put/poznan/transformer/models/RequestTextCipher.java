package pl.put.poznan.transformer.models;

import lombok.Data;

import java.util.List;

/**
 * Model for input text ciphers
 *
 * @author Michał Grygiel
 */
@Data
public class RequestTextCipher {

    private String inputText;
    private List<String> textCiphersNamesList;
    private List<Object> textCiphersArgsList;

}
