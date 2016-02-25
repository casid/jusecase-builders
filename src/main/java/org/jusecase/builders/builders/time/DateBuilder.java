package org.jusecase.builders.builders.time;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Immutable
public class DateBuilder implements Builder<Date> {
    protected final Date date;

    public DateBuilder(){
        this(new Date());
    }

    protected DateBuilder(final Date date){
        this.date = new Date(date.getTime());
    }

    public DateBuilder with(String string) throws ParseException {
        return with(string, "yyyy-MM-dd HH:mm:ss");
    }

    public DateBuilder with(String string, String format) throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return with(string, dateFormat);
    }

    public DateBuilder with(String string, SimpleDateFormat dateFormat) throws ParseException {
        return new DateBuilder(dateFormat.parse(string));
    }

    public Date build() {
        return new Date(this.date.getTime());
    }
}
