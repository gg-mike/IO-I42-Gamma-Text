package pl.put.poznan.transformer.models;

import lombok.Data;

import java.util.List;

@Data
public class RequestTextCipher {

    private String inputText;
    private List<String> textCiphersNamesList;
    private List<Object> textCiphersArgsList;

}
