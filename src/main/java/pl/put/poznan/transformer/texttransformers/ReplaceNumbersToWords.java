package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Replacing numbers to words
 *
 * @author Mikalai Chabatarevich
 * @see TextTransformer
 */
@Slf4j
@Component
public class ReplaceNumbersToWords implements TextTransformer {
    @Override
    public String transform(String text){

        HashMap<Character, String> map = new HashMap<Character, String>();

        map.put('0', "zero");
        map.put('1', "jeden");
        map.put('2', "dwa");
        map.put('3', "trzy");
        map.put('4', "cztery");
        map.put('5', "pięć");
        map.put('6', "sześć");
        map.put('7', "siedem");
        map.put('8', "osiem");
        map.put('9', "dziewięć");

        StringBuilder result = new StringBuilder();
        StringBuilder firstWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (map.containsKey(text.charAt(i))) {
                if (map.containsKey(text.charAt(i)) && i == 0) {
                    firstWord.append(map.get(text.charAt(i)));
                    firstWord.toString();
                    String temp = firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1);
                    result.append(temp);
                } else {
                    result.append(map.get(text.charAt(i)));
                }

            } else {
                result.append(text.charAt(i));
            }
        }
    return result.toString();
    }
}
