package org.jusecase.builders.time;

import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateBuilder implements Builder<Date> {
    private String string = null;
    private String formatString = "yyyy-MM-dd HH:mm:ss";
    private String timeZone = "UTC";
    private SimpleDateFormat format;

    public DateBuilder with(String string) {
        this.string = string;
        return this;
    }

    public DateBuilder withFormat(String format) {
        this.formatString = format;
        this.format = null;
        return this;
    }

    public DateBuilder withFormat(SimpleDateFormat format) {
        this.formatString = null;
        this.format = format;
        return this;
    }

    public DateBuilder withTimezone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    /**
     * Use withFormat() instead
     */
    @Deprecated
    public DateBuilder with(String string, String format) {
        return this.with(string).withFormat(format);
    }

    /**
     * Use withFormat() instead
     */
    @Deprecated
    public DateBuilder with(String string, SimpleDateFormat format) {
        return this.with(string).withFormat(format);
    }

    public Date build() {
        if (string == null) {
            return new Date();
        }

        try {
            return getFormat().parse(string);
        } catch (ParseException e) {
            throw new BuilderException("Failed to parse date from string.", e);
        }
    }

    private SimpleDateFormat getFormat() {
        if (format == null) {
            format = new SimpleDateFormat(formatString);
            format.setTimeZone(TimeZone.getTimeZone(timeZone));
        }
        return format;
    }
}
