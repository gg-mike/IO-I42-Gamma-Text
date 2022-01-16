package pl.put.poznan.transformer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @param <T>
 * @author Piotr Parzysz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pair<T> {

    private T first;
    private T second;

}
