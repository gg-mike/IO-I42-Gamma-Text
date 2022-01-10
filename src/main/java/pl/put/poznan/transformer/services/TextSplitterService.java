package pl.put.poznan.transformer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.exceptions.TextSplitterNotFoundException;
import pl.put.poznan.transformer.models.RequestTextSplitter;
import pl.put.poznan.transformer.models.ResponseTextSplitter;
import pl.put.poznan.transformer.textsplitters.TextSplitter;

import java.util.Map;

/**
 * Service class with text splitter logic
 *
 * @author Michał Grygiel
 * @see TextSplitter
 * @see RequestTextSplitter
 * @see ResponseTextSplitter
 */
@Service
public class TextSplitterService {

    @Autowired
    private Map<String, TextSplitter> textSplitterMap;

    /**
     * method which performs text splitter logic
     *
     * @param requestTextSplitter input text get split and set of text-splitter name
     * @return text and split text
     * @throws TextSplitterNotFoundException when text-splitter names is not known
     */
    public ResponseTextSplitter applyTextSplitter(RequestTextSplitter requestTextSplitter) throws TextSplitterNotFoundException {
        String splitName = requestTextSplitter.getTextSplitterName();
        if (!textSplitterMap.containsKey(splitName)) {
            throw new TextSplitterNotFoundException(splitName);
        }

        return new ResponseTextSplitter(
                requestTextSplitter.getInputText(),
                textSplitterMap.get(splitName).split(requestTextSplitter.getInputText()));
    }
}
