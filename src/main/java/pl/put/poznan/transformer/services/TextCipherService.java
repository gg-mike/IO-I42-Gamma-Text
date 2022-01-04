package pl.put.poznan.transformer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.exceptions.TextCipherNotFoundException;
import pl.put.poznan.transformer.models.RequestTextCipher;
import pl.put.poznan.transformer.models.ResponseTextCipher;
import pl.put.poznan.transformer.textciphers.TextCipher;

import java.util.Map;

/**
 * Service class with text cipher logic
 *
 * @author Michał Grygiel
 * @see TextCipher
 * @see RequestTextCipher
 * @see ResponseTextCipher
 */
@Service
public class TextCipherService {

    @Autowired
    private Map<String, TextCipher> textCipherMap;

    /**
     * method which performs text cipher logic
     *
     * @param requestTextCipher input text get ciphers and set of text-ciphers names
     * @return text and all ciphers
     * @throws TextCipherNotFoundException when list of text-ciphers names contains unknown name
     */
    public ResponseTextCipher applyTextCiphers(RequestTextCipher requestTextCipher) throws TextCipherNotFoundException {
        String cipheredText = requestTextCipher.getInputText();
        for (String cipherName : requestTextCipher.getTextCiphersNamesList()) {
            if (!textCipherMap.containsKey(cipherName)) {
                throw new TextCipherNotFoundException(cipherName);
            }
            cipheredText = textCipherMap.get(cipherName).cipher(requestTextCipher.getInputText(), requestTextCipher.getTextCiphersArgsList());
        }
        return new ResponseTextCipher(requestTextCipher.getInputText(), cipheredText);
    }

}
