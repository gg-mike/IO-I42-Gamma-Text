package pl.put.poznan.transformer.exceptions;

public class TextStatisticNotFoundException extends RuntimeException {

    public TextStatisticNotFoundException(String textStatisticName) {
        super("TextStatistic: { " + textStatisticName + " } not found");
    }

}
