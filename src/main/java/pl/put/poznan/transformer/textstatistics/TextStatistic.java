package pl.put.poznan.transformer.textstatistics;

/**
 * Interface for TextStatistics
 *
 * @author Piotr Parzysz
 */
public interface TextStatistic {

    /**
     * method used for text statistics
     *
     * @param text input text
     * @return statistics in any form
     */
    Object applyStatistic(String text);

}
