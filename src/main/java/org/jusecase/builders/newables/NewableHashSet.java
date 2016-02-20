package org.jusecase.builders.newables;

import org.jusecase.builders.Newable;

import java.util.HashSet;


public class NewableHashSet<T> implements Newable<HashSet<T>> {
    @Override
    public HashSet<T> newInstance() {
        return new HashSet<T>();
    }
}
