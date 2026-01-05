package org.jusecase.builders.streams;

import java.io.InputStream;

import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

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
            throw new BuilderException("Resource " + resource + " not found.");
        }
        return is;
    }
}
