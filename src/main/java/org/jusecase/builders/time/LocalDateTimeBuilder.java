package org.jusecase.builders.time;

import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeBuilder implements Builder<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String string;

    public LocalDateTimeBuilder() {
        this("2015-10-21 07:28:00");
    }

    public LocalDateTimeBuilder(String string) {
        this.string = string;
    }

    @Override
    public LocalDateTime build() {
        try {
            return LocalDateTime.parse(string, FORMATTER);
        } catch (Exception e) {
            throw new BuilderException("Failed to parse date from string.", e);
        }
    }

}
