package org.jusecase.builders.streams;

import org.jusecase.builders.Builder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public class StringInputStreamBuilder implements Builder<InputStream> {
    private final String content;

    public StringInputStreamBuilder() {
        this("");
    }

    public StringInputStreamBuilder(String content) {
        if (content == null) {
            throw new NullPointerException("string content may not be null");
        }
        this.content = content;
    }

    @Override
    public InputStream build() {
        final byte[] stringAsBytes = content.getBytes(Charset.forName("UTF-8"));
        return new ByteArrayInputStream(stringAsBytes);
    }
}
