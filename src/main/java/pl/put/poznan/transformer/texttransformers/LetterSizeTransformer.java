package pl.put.poznan.transformer.texttransformers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Scanner;

/**
 * Zmianać wielkości liter – upper, lower, capitalize
 *
 * @author Mikalai Chabatarevich
 * @see TextTransformer
 */

public class LetterSizeTransformer implements TextTransformer {
    //@Override

    public static String Upper(String text) {
        String result = text.toUpperCase();
        return result;
    }

    public static String Lower(String text) {
        String result = text.toLowerCase();
        return result;
    }

    public static StringBuffer Capital(String text) {
        String[] words;
        words = text.split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            String resultWord = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            result.append(resultWord);
            result.append(" ");
        }
        return result;
    }

    public String transform(String text) {
        Scanner in = new Scanner(System.in);

        String result;
        StringBuffer resultStrBuf;

        System.out.println("=====================================================================");
        System.out.println("Choose the function ('up' - Upper, 'low' - Lower, 'cap' - Capital): ");
        System.out.println("=====================================================================");

        String func = in.nextLine();

        while (true) {
            if (func.equals("up") | func.equals("low") | func.equals("cap")) {
                break;
            } else {
                System.out.println("Error! Check the entered data and try again");
            }
            System.out.println(func);
            func = in.nextLine();
        }

        if (func.equals("up")) {
            result = Upper(text);
            return result;
        } else if (func.equals("low")) {
            result = Lower(text);
            return result;
        } else {
            resultStrBuf = Capital(text);
            return resultStrBuf.toString();
        }
    }
}