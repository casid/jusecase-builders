package org.jusecase.builders.newables;

import org.jusecase.builders.Newable;

import java.util.LinkedList;
import java.util.List;

public class NewableLinkedList<T> implements Newable<List<T>> {
    @Override
    public List<T> newInstance() {
        return new LinkedList<T>();
    }
}
