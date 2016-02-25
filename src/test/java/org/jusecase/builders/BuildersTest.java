package org.jusecase.builders;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.jusecase.builders.Builders.a;
import static org.jusecase.builders.Builders.an;
import static org.jusecase.builders.Builders.of;

public class BuildersTest implements Builder<String> {

    private boolean buildHasBeenCalled;

    @Before
    public void setUp() throws Exception {
        this.buildHasBeenCalled = false;
    }

    @Test
    public void testAIsCallingBuild() throws Exception {
        a(this);
        assertTrue(this.buildHasBeenCalled);
    }

    @Test
    public void testAnIsCallingBuild() throws Exception {
        an(this);
        assertTrue(this.buildHasBeenCalled);
    }

    @Test
    public void testOfReturnsInput() throws Exception {
        final String input = "input";
        final String output = of(input);
        assertEquals(input, output);
    }

    @Test
    public void testOfArrayReturnsInput() throws Exception {
        final String[] input = new String[]{"input"};
        final String[] output = of(input);
        assertSame(input, output);
    }

    @Override
    public String build() {
        this.buildHasBeenCalled = true;
        return "";
    }
}
