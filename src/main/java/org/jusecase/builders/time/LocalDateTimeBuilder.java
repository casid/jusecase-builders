package org.jusecase.builders.time;

import org.jusecase.Builders;
import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.jusecase.Builders.a;
import static org.jusecase.Builders.localDate;

public class LocalDateTimeBuilder implements Builder<LocalDateTime> {

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String SHORT_FORMAT = "yyyy-MM-dd";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT);

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
            return parse();
        } catch (Exception e) {
            throw new BuilderException("Failed to parse date from string.", e);
        }
    }

    private LocalDateTime parse() {
        if ( string.length() <= SHORT_FORMAT.length() ) {
            LocalDate localDate = a(localDate(string));
            return LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0);
        }
        return LocalDateTime.parse(string, FORMATTER);
    }

}
