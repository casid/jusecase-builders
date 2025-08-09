package org.jusecase.builders.time;

import org.junit.jupiter.api.Test;
import org.jusecase.builders.BuilderException;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.localDateTime;

public class LocalDateTimeBuilderTest {


    @Test
    public void dateCannotBeParsed() {
        assertThrows(BuilderException.class, () -> a(localDateTime("iedio")));
    }

    @Test
    public void defaultDate() {
        assertThat(a(localDateTime())).isEqualTo(a(localDateTime("2015-10-21 07:28:00")));
    }

    @Test
    public void dateTimeIsParsedCorrectly() {
        LocalDateTime dateTime = a(localDateTime("2016-01-01 08:30:40"));
        assertThat(2016).isEqualTo(dateTime.getYear());
        assertThat(1).isEqualTo(dateTime.getMonthValue());
        assertThat(1).isEqualTo(dateTime.getDayOfMonth());
        assertThat(8).isEqualTo(dateTime.getHour());
        assertThat(30).isEqualTo(dateTime.getMinute());
        assertThat(40).isEqualTo(dateTime.getSecond());
    }

    @Test
    public void shortDateTimeIsParsedCorrectly() {
        LocalDateTime dateTime = a(localDateTime("2016-01-01"));
        assertThat(2016).isEqualTo(dateTime.getYear());
        assertThat(1).isEqualTo(dateTime.getMonthValue());
        assertThat(1).isEqualTo(dateTime.getDayOfMonth());
        assertThat(0).isEqualTo(dateTime.getHour());
        assertThat(0).isEqualTo(dateTime.getMinute());
        assertThat(0).isEqualTo(dateTime.getSecond());
    }
}
