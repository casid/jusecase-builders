package org.jusecase.builders;

import org.jusecase.builders.builders.misc.DateBuilder;
import org.jusecase.builders.builders.streams.InputStreamBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
