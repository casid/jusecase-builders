package org.jusecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.jusecase.builders.Builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.*;

public class BuildersTest implements Builder<String> {

    private boolean buildHasBeenCalled;

    @BeforeEach
    public void setUp() throws Exception {
        this.buildHasBeenCalled = false;
    }

    @Test
    public void testAIsCallingBuild() throws Exception {
        a(this);
        assertThat(this.buildHasBeenCalled).isTrue();
    }

    @Test
    public void testAnIsCallingBuild() throws Exception {
        an(this);
        assertThat(this.buildHasBeenCalled).isTrue();
    }

    @Test
    public void testOfReturnsInput() throws Exception {
        final String input = "input";
        final String output = of(input);
        assertThat(output).isEqualTo(input);
    }

    @Test
    public void testOfArrayReturnsInput() throws Exception {
        final String[] input = new String[]{"input"};
        final String[] output = of(input);
        assertThat(output).isEqualTo(input);
    }

    @Override
    public String build() {
        this.buildHasBeenCalled = true;
        return "";
    }
}
