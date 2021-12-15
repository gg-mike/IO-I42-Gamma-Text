package pl.put.poznan.transformer.models;

import lombok.Data;

/**
 * @param <T>
 * @author Piotr Parzysz
 */
@Data
public class Pair<T> {

    private T first;
    private T second;

}
