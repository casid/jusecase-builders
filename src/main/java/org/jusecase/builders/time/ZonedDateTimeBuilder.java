package org.jusecase.builders.time;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

public class ZonedDateTimeBuilder implements Builder<ZonedDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

    private final String string;

    public ZonedDateTimeBuilder() {
        this("2015-10-21 07:28:00 Europe/Berlin");
    }

    public ZonedDateTimeBuilder(String string) {
        this.string = string;
    }

    @Override
    public ZonedDateTime build() {
        try {
            return ZonedDateTime.parse(string, FORMATTER);
        } catch (Exception e) {
            throw new BuilderException("Failed to parse date from string.", e);
        }
    }

}
