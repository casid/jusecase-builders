package org.jusecase.builders.io;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.jusecase.builders.Builder;
import org.jusecase.builders.BuilderException;

public class FileBuilder implements Builder<File> {
    private String resource;

    public FileBuilder withResource(String resource) {
        this.resource = resource;
        if (resource == null) {
            throw new NullPointerException("Resource may not be null.");
        }
        return this;
    }

    @Override
    public File build() {
        if (resource == null) {
            return new File("");
        }

        URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
        if (url == null) {
            throw new BuilderException("Resource " + resource + " not found.");
        }

        try {
            return new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new BuilderException("Resource " + resource + " not found.", e);
        }
    }
}
