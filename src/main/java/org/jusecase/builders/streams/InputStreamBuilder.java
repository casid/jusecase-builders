package org.jusecase.builders.streams;

import java.io.InputStream;

import org.jusecase.builders.Builder;

public class InputStreamBuilder implements Builder<InputStream> {

    private Builder<InputStream> concreteBuilder;

    public InputStreamBuilder() {
        concreteBuilder = new StringInputStreamBuilder();
    }

    public InputStreamBuilder withString(String content) {
        concreteBuilder = new StringInputStreamBuilder(content);
        return this;
    }

    public InputStreamBuilder withResource(String resource) {
        concreteBuilder = new ResourceInputStreamBuilder(resource);
        return this;
    }

    @Override
    public InputStream build() {
        return concreteBuilder.build();
    }
}
