package org.jusecase.builders.newables;

import org.jusecase.builders.Newable;

import java.util.HashSet;
import java.util.Set;


public class NewableHashSet<T> implements Newable<Set<T>> {
    @Override
    public Set<T> newInstance() {
        return new HashSet<T>();
    }
}
