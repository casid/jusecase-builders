package org.jusecase.builders.factories;

import org.jusecase.builders.builders.streams.ResourceInputStreamBuilder;
import org.jusecase.builders.builders.streams.StringInputStreamBuilder;

public class InputStreamBuilderFactory {

    public static StringInputStreamBuilder stringStream(final String content){
        return new StringInputStreamBuilder().withString(content);
    }

    public static ResourceInputStreamBuilder resourceStream(final String resource){
        return new ResourceInputStreamBuilder().withResource(resource);
    }

}
