package org.jusecase.builders.io;

import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathBuilder implements Builder<Path> {
    private String resource;

    public PathBuilder withResource(String resource) {
        this.resource = resource;
        if (resource == null) {
            throw new NullPointerException("Resource may not be null.");
        }
        return this;
    }

    @Override
    public Path build() {
        if (resource == null) {
            return Paths.get("");
        }

        URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
        if (url == null) {
            throw new BuilderException("Resource " + resource + " not found.");
        }

        try {
            return Paths.get(url.toURI());
        } catch (URISyntaxException e) {
            throw new BuilderException("Resource " + resource + " not found.", e);
        }
    }
}
