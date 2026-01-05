package org.jusecase.builders.time;

import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateBuilder implements Builder<Date> {
    private static final String DEFAULT_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
    private static final String SHORT_FORMAT_STRING = "yyyy-MM-dd";

    private String string;
    private String formatString;
    private String timeZone = "UTC";
    private SimpleDateFormat format;

    public DateBuilder() {
        this.string = "2015-10-21 07:28:00";
    }

    public DateBuilder now() {
        this.string = null;
        return this;
    }

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
     * @deprecated Use {@link #withFormat(String)} instead
     */
    @Deprecated
    public DateBuilder with(String string, String format) {
        return this.with(string).withFormat(format);
    }

    /**
     * @deprecated Use {@link #withFormat(SimpleDateFormat)} instead
     */
    @Deprecated
    public DateBuilder with(String string, SimpleDateFormat format) {
        return this.with(string).withFormat(format);
    }

    public Date build() {
        if (string == null) {
            return new Date();
        }

        if (formatString == null && string.length() <= SHORT_FORMAT_STRING.length()) {
            formatString = SHORT_FORMAT_STRING;
        }

        try {
            return getFormat().parse(string);
        } catch (ParseException e) {
            throw new BuilderException("Failed to parse date from string.", e);
        }
    }

    private SimpleDateFormat getFormat() {
        if (format == null) {
            format = new SimpleDateFormat(formatString == null ? DEFAULT_FORMAT_STRING : formatString);
            format.setTimeZone(TimeZone.getTimeZone(timeZone));
        }
        return format;
    }
}
