package org.jusecase.builders.time;

import org.jusecase.Builder;
import org.jusecase.BuilderException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateBuilder implements Builder<Date> {
    protected final Date date;

    public DateBuilder(){
        this(new Date());
    }

    protected DateBuilder(final Date date){
        this.date = new Date(date.getTime());
    }

    public DateBuilder with(String string) {
        return with(string, "yyyy-MM-dd HH:mm:ss");
    }

    public DateBuilder with(String string, String format) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return with(string, dateFormat);
    }

    public DateBuilder with(String string, SimpleDateFormat dateFormat) {
        try {
            return new DateBuilder(dateFormat.parse(string));
        } catch (ParseException e) {
            throw new BuilderException("Failed to parse date from string.", e);
        }
    }

    public Date build() {
        return new Date(this.date.getTime());
    }
}
