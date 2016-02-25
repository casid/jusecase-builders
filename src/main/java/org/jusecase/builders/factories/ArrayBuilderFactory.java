package org.jusecase.builders.factories;

import org.jusecase.builders.builders.structures.ArrayBuilder;
import org.jusecase.builders.newables.NewableArrayList;
import org.jusecase.builders.newables.NewableCollection;

public class ArrayBuilderFactory {

    public static <T> ArrayBuilder<T> array(final T ... items) {
        return new ArrayBuilder<T>(items);
    }
}
