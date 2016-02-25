package org.jusecase.builders.builders.streams;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

@RunWith(ZohhakRunner.class)
public class ResourceInputStreamBuilderTest {
    private final ResourceInputStreamBuilder builder = new ResourceInputStreamBuilder();

    @Test
    public void testBuildResultIsNotNullAfterConstruction() throws Exception {
        assertNotNull(builder.build());
    }

    @Test
    public void testCallingBuildWillReturnACopy() throws Exception {
        final InputStream buildResult = builder.build();
        assertNotSame(buildResult, builder.build());
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
    public void testBuildIsNotNull(final String resource) throws Exception {
        final InputStream resourceStream = builder.withResource(resource).build();
        assertNotNull(resourceStream);
    }

    @Test(expected = NullPointerException.class)
    public void testThrowNPEWhenResourceIsNotFound() throws Exception {
        final InputStream resourceStream = builder.withResource("not existing resource").build();
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