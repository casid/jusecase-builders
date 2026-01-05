package org.jusecase.builders.time;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;
import org.jusecase.builders.BuilderException;

public class DateBuilderTest {

    private static final long CET_DIFFERENCE = 3600 * 1000;

    @Test
    public void dateCannotBeParsed() {
        assertThrows(BuilderException.class, () -> a(date().with("iedio")));
    }

    @Test
    public void defaultDate() {
        assertThat(a(date())).isEqualTo(a(date("2015-10-21 07:28:00")));
    }

    @Test
    public void now() {
        assertThat(new Date().getTime() <= a(date().now()).getTime()).isTrue();
    }

    @Test
    public void dateWithExplicitWith() {
        assertThat(a(date().with("2016-01-01 00:00:01"))).isEqualTo(new Date(1451606401000L));
    }

    @Test
    public void dateIsParsedCorrectly() {
        assertThat(a(date("2016-01-01 00:00:01"))).isEqualTo(new Date(1451606401000L));
    }

    @Test
    public void dateIsParsedCorrectly_onlyDatePart() {
        assertThat(a(date("2016-01-01"))).isEqualTo(new Date(1451606400000L));
    }

    @Test
    public void dateWithFormatIsParsedCorrectly() {
        assertThat(a(date("2016-01-01").withFormat("yyyy-MM-dd"))).isEqualTo(new Date(1451606400000L));
    }

    @Test
    public void dateWithFormatIsParsedCorrectly_legacyWay() {
        assertThat(a(date().with("2016-01-01", "yyyy-MM-dd"))).isEqualTo(new Date(1451606400000L));
    }

    @Test
    public void dateWithTimezoneIsParsedCorrectly() {
        assertThat(a(date("2016-01-01 00:00:01").withTimezone("CET"))).isEqualTo(new Date(1451606401000L - CET_DIFFERENCE));
    }

    @Test
    public void dateWithCustomFormatIsParsedCorrectly() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));

        assertThat(a(date("2016-01-01").withFormat(dateFormat))).isEqualTo(new Date(1451606400000L - CET_DIFFERENCE));
    }

    @Test
    public void dateWithCustomFormatIsParsedCorrectly_legacyWay() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));

        assertThat(a(date().with("2016-01-01", dateFormat))).isEqualTo(new Date(1451606400000L - CET_DIFFERENCE));
    }
}
