package org.jusecase.builders.streams;

import org.jusecase.builders.Builder;

import java.io.InputStream;

public class ResourceInputStreamBuilder implements Builder<InputStream> {
    private final String resource;

    public ResourceInputStreamBuilder(final String resource){
        if (resource == null) {
            throw new NullPointerException("Resource may not be null.");
        }
        this.resource = resource;
    }

    public InputStream build() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        if (is == null) {
            throw new NullPointerException("Resource " + resource + " not found.");
        }
        return is;
    }
}
