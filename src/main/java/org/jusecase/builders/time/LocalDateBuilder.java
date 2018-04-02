package org.jusecase.builders.time;

import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

import java.time.LocalDate;

public class LocalDateBuilder implements Builder<LocalDate> {

    private String string;

    public LocalDateBuilder() {
        this("2015-10-21");
    }

    public LocalDateBuilder(String string) {
        this.string = string;
    }

    @Override
    public LocalDate build() {
        try {
            return LocalDate.parse(string);
        } catch (Exception e) {
            throw new BuilderException("Failed to parse date from string.", e);
        }
    }
}
