package org.jusecase.builders.factories;

import org.jusecase.builders.builders.streams.InputStreamBuilder;

public class InputStreamBuilderFactory {

    public static InputStreamBuilder stringStream(final String content){
        return new InputStreamBuilder().withString(content);
    }

    public static InputStreamBuilder resourceStream(final String resource){
        return new InputStreamBuilder().withResource(resource);
    }

}
