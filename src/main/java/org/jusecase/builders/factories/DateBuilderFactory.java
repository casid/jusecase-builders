package org.jusecase.builders.factories;

import org.jusecase.builders.builders.misc.DateBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateBuilderFactory {

    public static DateBuilder date(final String dateString) throws ParseException {
        return new DateBuilder().with(dateString);
    }

    public static DateBuilder date(final String dateString, final SimpleDateFormat format) throws ParseException {
        return new DateBuilder().with(dateString, format);
    }
}
