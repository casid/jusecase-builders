package org.jusecase.builders.builders.streams;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.jusecase.builders.helpers.Preconditions.requireNonNull;

@Immutable
public class StringInputStreamBuilder implements Builder<InputStream> {
    private final String content;

    public StringInputStreamBuilder() {
        this("");
    }

    public StringInputStreamBuilder(String content) {
        this.content = requireNonNull(content, "string content may not be null");;
    }

    @Override
    public InputStream build() {
        final byte[] stringAsBytes = content.getBytes(Charset.forName("UTF-8"));
        return new ByteArrayInputStream(stringAsBytes);
    }
}
