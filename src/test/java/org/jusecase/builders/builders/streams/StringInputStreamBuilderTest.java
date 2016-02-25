package org.jusecase.builders.builders.streams;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

@RunWith(ZohhakRunner.class)
public class StringInputStreamBuilderTest {
    private final StringInputStreamBuilder builder = new StringInputStreamBuilder();

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
        final StringInputStreamBuilder builderCopy = builder.withString("");
        assertNotSame(builderCopy, builder);
    }

    @TestWith({
            "test",
            "test123",
            "test test"
    })
    public void testOutputEqualsInput(final String content) throws Exception {
        final InputStream stringStream = builder.withString(content).build();
        assertEquals(content, toString(stringStream));
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