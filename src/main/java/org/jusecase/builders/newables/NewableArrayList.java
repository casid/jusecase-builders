package org.jusecase.builders.newables;

import org.jusecase.builders.Newable;

import java.util.ArrayList;
import java.util.List;


public class NewableArrayList<T> implements Newable<List<T>> {
    @Override
    public List<T> newInstance() {
        return new ArrayList<T>();
    }
}
