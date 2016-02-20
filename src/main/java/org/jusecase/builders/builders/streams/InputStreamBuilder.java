package org.jusecase.builders.builders.streams;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

@Immutable
public class InputStreamBuilder implements Builder<InputStream> {
    protected final InputStream inputStream;

    public InputStreamBuilder() {
        this("".getBytes());
    }

    protected InputStreamBuilder(final byte[] bytes){
        this.inputStream = new ByteArrayInputStream(bytes);
    }

    protected InputStreamBuilder(final InputStream stream){
        this.inputStream = stream;
    }

    public InputStreamBuilder withString(String content) {
        final byte[] stringAsBytes  = content.getBytes(Charset.forName("UTF-8"));
        return new InputStreamBuilder(stringAsBytes);
    }

    public InputStreamBuilder withResource(String resource) {
        final InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        return new InputStreamBuilder(resourceAsStream);
    }

    public InputStream build() {
        return inputStream;
    }
}
