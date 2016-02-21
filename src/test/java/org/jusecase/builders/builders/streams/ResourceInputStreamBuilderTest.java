package org.jusecase.builders.builders.streams;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jusecase.builders.ErrorTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(ZohhakRunner.class)
public class ResourceInputStreamBuilderTest {
    private final ResourceInputStreamBuilder builder = new ResourceInputStreamBuilder();

    @Test
    public void testBuildResultIsNotNullAfterConstruction() throws Exception {
        assertNotNull(builder.build().get());
    }

    @Test
    public void testCallingBuildWillReturnACopy() throws Exception {
        final Optional<InputStream> buildResult = builder.build();
        assertNotSame(buildResult, builder.build().get());
    }

    @Test
    public void testCallingWithReturnNewBuilderInstance() throws Exception {
        final ResourceInputStreamBuilder builderCopy = builder.withResource("");
        assertNotSame(builderCopy, builder);
    }

    @TestWith({
            "testresource.txt",
            ""
    })
    public void testBuildIsPresent(final String resource) throws Exception {
        final Optional<InputStream> resourceStream = builder.withResource(resource).build();
        assertTrue(resourceStream.isPresent());
    }

    @TestWith({
            "nonexistingresource.txt"
    })
    public void testBuildIsNotPresent(final String resource) throws Exception {
        final Optional<InputStream> resourceStream = builder.withResource(resource).build();
        assertFalse(resourceStream.isPresent());
    }

    private String toString(final InputStream stream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = stream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }


}