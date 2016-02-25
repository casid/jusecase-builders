package org.jusecase.builders.builders.streams;

import org.jusecase.builders.Builder;
import org.jusecase.builders.Immutable;

import java.io.InputStream;

import static org.jusecase.builders.helpers.Preconditions.requireNonNull;

@Immutable
public class ResourceInputStreamBuilder implements Builder<InputStream> {
    private final String resource;

    public ResourceInputStreamBuilder(final String resource){
        this.resource = requireNonNull(resource, "resource may not be null");
    }

    public InputStream build() {
        return requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource), "resource not found");
    }
}
