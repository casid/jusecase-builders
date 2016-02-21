package org.jusecase.builders.builders.streams;

import jdk.internal.util.xml.impl.Input;
import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Immutable
public class ResourceInputStreamBuilder implements Builder<Optional<InputStream>> {
    protected final String resource;

    public ResourceInputStreamBuilder() {
        this("");
    }

    protected ResourceInputStreamBuilder(final String resource){
        requireNonNull(resource, "resource may not be null");
        this.resource = resource;
    }

    public ResourceInputStreamBuilder withResource(String resource) {
        return new ResourceInputStreamBuilder(resource);
    }

    public Optional<InputStream> build() {
        return Optional.ofNullable(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
