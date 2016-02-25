package org.jusecase.builders.newables;

import org.jusecase.builders.Newable;

import java.util.ArrayList;
import java.util.Collection;

public class NewableCollection<T> implements Newable<Collection<T>> {
    @Override
    public Collection<T> newInstance() {
        return new ArrayList<T>();
    }
}
