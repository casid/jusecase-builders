package org.jusecase.builders.time;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.localDate;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.jusecase.builders.BuilderException;

public class LocalDateBuilderTest {

    @Test
    public void dateCannotBeParsed() {
        assertThrows(BuilderException.class, () -> a(localDate("iedio")));
    }

    @Test
    public void timeCannotBeParsed() {
        assertThrows(BuilderException.class, () -> a(localDate("2016-01-01 00:00:01")));
    }

    @Test
    public void defaultDate() {
        assertThat(a(localDate())).isEqualTo(a(localDate("2015-10-21")));
    }

    @Test
    public void dateIsParsedCorrectly() {
        LocalDate date = a(localDate("2016-01-01"));
        assertThat(2016).isEqualTo(date.getYear());
        assertThat(1).isEqualTo(date.getMonthValue());
        assertThat(1).isEqualTo(date.getDayOfMonth());
    }
}
