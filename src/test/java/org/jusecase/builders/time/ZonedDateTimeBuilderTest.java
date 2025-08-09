package org.jusecase.builders.time;

import org.junit.jupiter.api.Test;
import org.jusecase.builders.BuilderException;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.zonedDateTime;

public class ZonedDateTimeBuilderTest {

    @Test
    public void dateCannotBeParsed() {
        assertThrows(BuilderException.class, () -> a(zonedDateTime("iedio")));
    }

    @Test
    public void defaultDate() {
        assertThat(a(zonedDateTime())).isEqualTo(a(zonedDateTime("2015-10-21 07:28:00 Europe/Berlin")));
    }

    @Test
    public void dateIsParsedCorrectly() {
        ZonedDateTime dateTime = a(zonedDateTime("2016-01-01 08:30:40 Europe/Berlin"));
        assertThat(2016).isEqualTo(dateTime.getYear());
        assertThat(1).isEqualTo(dateTime.getMonthValue());
        assertThat(1).isEqualTo(dateTime.getDayOfMonth());
        assertThat(8).isEqualTo(dateTime.getHour());
        assertThat(30).isEqualTo(dateTime.getMinute());
        assertThat(40).isEqualTo(dateTime.getSecond());
    }
}
