package org.jusecase.builders.streams;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.jusecase.builders.Builder;


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
        final byte[] stringAsBytes = content.getBytes(StandardCharsets.UTF_8);
        return new ByteArrayInputStream(stringAsBytes);
    }
}
