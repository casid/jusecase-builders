package org.jusecase.builders.streams;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.jusecase.BuilderException;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.inputStream;

public class InputStreamBuilderTest {
    @Test
    public void inputStreamWithoutAdjustments() throws Exception {
        inputStreamIsEqualTo(a(inputStream()), "");
    }

    @Test(expected = NullPointerException.class)
    public void inputStreamWithNullString() throws Exception {
        a(inputStream().withString(null));
    }

    @Test
    public void inputStreamWithString() throws Exception {
        inputStreamIsEqualTo(a(inputStream().withString("1234")), "1234");
    }

    @Test(expected = NullPointerException.class)
    public void inputStreamWithNullResource() throws Exception {
        a(inputStream().withResource(null));
    }

    @Test(expected = BuilderException.class)
    public void inputStreamWithResourceThatDoesNotExist() throws Exception {
        a(inputStream().withResource("unknown.txt"));
    }

    @Test
    public void inputStreamWithResource() throws Exception {
        inputStreamIsEqualTo(a(inputStream().withResource("testresource.txt")), "this is a test");
    }

    private void inputStreamIsEqualTo(InputStream inputStream, String expected) throws Exception {
        assertEquals(expected, IOUtils.toString(inputStream));
    }
}
