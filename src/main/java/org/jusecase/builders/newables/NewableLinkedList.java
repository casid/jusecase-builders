package org.jusecase.builders.newables;

import org.jusecase.builders.Newable;

import java.util.LinkedList;

public class NewableLinkedList<T> implements Newable<LinkedList<T>> {
    @Override
    public LinkedList<T> newInstance() {
        return new LinkedList<T>();
    }
}
