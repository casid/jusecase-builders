package org.jusecase.builders.builders.streams;

import org.jusecase.builders.Builder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public class StringInputStreamBuilder implements Builder<InputStream> {
    protected final byte[] stringAsBytes;

    public StringInputStreamBuilder() {
        this("".getBytes());
    }

    protected StringInputStreamBuilder(final byte[] bytes){
        this.stringAsBytes = bytes;
    }
    public StringInputStreamBuilder withString(String content) {
        final byte[] stringAsBytes  = content.getBytes(Charset.forName("UTF-8"));
        return new StringInputStreamBuilder(stringAsBytes);
    }

    @Override
    public InputStream build() {
        return new ByteArrayInputStream(stringAsBytes);
    }


}
