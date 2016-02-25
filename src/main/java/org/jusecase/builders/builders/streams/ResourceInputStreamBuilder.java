package org.jusecase.builders.builders.streams;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;

import java.io.InputStream;

import static org.jusecase.builders.helpers.Preconditions.requireNonNull;

@Immutable
public class ResourceInputStreamBuilder implements Builder<InputStream> {
    protected final String resource;

    public ResourceInputStreamBuilder() {
        this("");
    }

    protected ResourceInputStreamBuilder(final String resource){
        this.resource = requireNonNull(resource, "resource may not be null");;
    }

    public ResourceInputStreamBuilder withResource(String resource) {
        requireNonNull(resource, "resource may not be null");
        return new ResourceInputStreamBuilder(resource);
    }

    public InputStream build() {
        final InputStream result = requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource), "resource not found");
        return result;
    }
}
