package org.jusecase.builders;

import org.junit.Assert;

public class ErrorTest {
    public class ThereWasNoError extends Throwable{

    }
    protected Throwable error = new ThereWasNoError();

    protected void given(final Given given){
        try {
            given.that();
        } catch (Throwable e) {
            this.error = e;
        }
    }

    protected void when(final When when){
        try {
            when.isExecuted();
        } catch (Throwable e) {
            this.error = e;
        }
    }

    protected void thenErrorIs(Throwable expected) {
        Assert.assertEquals(expected, this.error);
    }

    protected void thenErrorIs(Class<? extends Throwable> expected) {
        Assert.assertEquals(expected, this.error.getClass());
    }

    protected void thenErrorMessageIs(String expected) {
        Assert.assertNotNull("Expected error with message \'" + expected + "\', but nothing was thrown.", this.error);
        Assert.assertEquals(expected, this.error.getMessage());
    }
}
