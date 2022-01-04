package pl.put.poznan.transformer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseTextCipher {

    private String originalText;
    private String cipheredText;

}
