package org.jusecase.builders;

import org.jusecase.builders.builders.collections.ListBuilder;
import org.jusecase.builders.builders.collections.SetBuilder;
import org.jusecase.builders.builders.streams.InputStreamBuilder;
import org.jusecase.builders.builders.structures.ArrayBuilder;
import org.jusecase.builders.builders.time.DateBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Builders {
    public static <T> T a(final Builder<T> builder) {
        return builder.build();
    }

    public static <T> T an(final Builder<T> builder) {
        return builder.build();
    }

    public static <T> T of(final T entity) {
        return entity;
    }

    public static <T> T[] of(final T... entities) {
        return entities;
    }

    public static <T> ArrayBuilder<T> array(final T ... items) {
        return new ArrayBuilder<T>(items);
    }

    public static <T> ListBuilder<T> list(final T ... items) {
        return arrayList(items);
    }

    public static <T> ListBuilder<T> arrayList(final T ... items) {
        return new ListBuilder<T>(new ArrayList<T>(), items);
    }

    public static <T> ListBuilder<T> linkedList(final T ... items) {
        return new ListBuilder<T>(new LinkedList<T>(), items);
    }

    public static <T> SetBuilder<T> set(final T ... items) {
        return hashSet(items);
    }

    public static <T> SetBuilder<T> hashSet(final T ... items) {
        return new SetBuilder<T>(new HashSet<T>(), items);
    }

    public static DateBuilder date(final String dateString) throws ParseException {
        return new DateBuilder().with(dateString);
    }

    public static DateBuilder date(final String dateString, final String formatString) throws ParseException {
        return new DateBuilder().with(dateString, formatString);
    }

    public static DateBuilder date(final String dateString, final SimpleDateFormat format) throws ParseException {
        return new DateBuilder().with(dateString, format);
    }

    public static InputStreamBuilder inputStream() {
        return new InputStreamBuilder();
    }
}
