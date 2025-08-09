package org.jusecase.builders.streams;

import org.junit.jupiter.api.Test;
import org.jusecase.builders.BuilderException;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.inputStream;

public class InputStreamBuilderTest {
    @Test
    public void inputStreamWithoutAdjustments() throws Exception {
        inputStreamIsEqualTo(a(inputStream()), "");
    }

    @Test
    public void inputStreamWithNullString() throws Exception {
        assertThrows(NullPointerException.class, () -> a(inputStream().withString(null)));
    }

    @Test
    public void inputStreamWithString() throws Exception {
        inputStreamIsEqualTo(a(inputStream().withString("1234")), "1234");
    }

    @Test
    public void inputStreamWithNullResource() throws Exception {
        assertThrows(NullPointerException.class, () -> a(inputStream().withResource(null)));
    }

    @Test
    public void inputStreamWithResourceThatDoesNotExist() throws Exception {
        assertThrows(BuilderException.class, () -> a(inputStream().withResource("unknown.txt")));
    }

    @Test
    public void inputStreamWithResource() throws Exception {
        inputStreamIsEqualTo(a(inputStream().withResource("testresource.txt")), "this is a test");
    }

    private void inputStreamIsEqualTo(InputStream inputStream, String expected) throws Exception {
        assertThat(new String(inputStream.readAllBytes())).isEqualTo(expected);
    }
}
