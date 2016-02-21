package org.jusecase.builders;

import org.junit.Before;
import org.junit.Test;
import org.jusecase.builders.builders.collections.*;
import org.jusecase.builders.builders.misc.DateBuilder;
import org.jusecase.builders.builders.streams.ResourceInputStreamBuilder;
import org.jusecase.builders.builders.streams.StringInputStreamBuilder;
import org.jusecase.builders.newables.NewableArrayList;

import static org.junit.Assert.*;
import static org.jusecase.builders.BuilderFactory.*;

public class BuilderFactoryTest implements Builder<String> {
    private boolean buildHasBeenCalled;

    @Before
    public void setUp() throws Exception {
        this.buildHasBeenCalled = false;
    }

    @Test
    public void testInstanceIsNotNull() {
        instanceCanBeBuilt(createCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createCopyCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createAggregateCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createUnmodifiableCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createImmutableCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createResourceInputStreamBuilder());
        instanceCanBeBuilt(createStringInputStreamBuilder());
        instanceCanBeBuilt(createDateBuilder());
    }

    @Test
    public void testBuilderEqualsClass() throws Exception {
        builderEqualsClass(createCollectionBuilder(new NewableArrayList<Object>()), CollectionBuilder.class, "createCollectionBuilder failed");
        builderEqualsClass(createCopyCollectionBuilder(new NewableArrayList<Object>()), CopyCollectionBuilder.class, "createCopyCollectionBuilder failed");
        builderEqualsClass(createAggregateCollectionBuilder(new NewableArrayList<Object>()), AggregateCollectionBuilder.class, "createAggregateCollectionBuilder failed");
        builderEqualsClass(createUnmodifiableCollectionBuilder(new NewableArrayList<Object>()), UnmodifiableCollectionBuilder.class, "createUnmodifiableCollectionBuilder failed");
        builderEqualsClass(createImmutableCollectionBuilder(new NewableArrayList<Object>()), ImmutableCollectionBuilder.class, "createImmutableCollectionBuilder failed");
        builderEqualsClass(createResourceInputStreamBuilder(), ResourceInputStreamBuilder.class, "createResourceInputStreamBuilder failed");
        builderEqualsClass(createStringInputStreamBuilder(), StringInputStreamBuilder.class, "createStringInputStreamBuilder failed");
        builderEqualsClass(createDateBuilder(), DateBuilder.class, "createDateBuilder failed");
    }

    @Test
    public void testBuilderIsNotNull() {
        assertNotNull(createCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createCopyCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createAggregateCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createUnmodifiableCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createImmutableCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createResourceInputStreamBuilder());
        assertNotNull(createStringInputStreamBuilder());
        assertNotNull(createDateBuilder());
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

    private <T> void instanceCanBeBuilt(Builder<T> builder) {
        T instance = a(builder);
        assertNotNull(instance);
    }

    private <T, R> void builderEqualsClass(Builder<T> builder, Class<R> expectedClass, String message) {
        assertTrue(message, expectedClass.isInstance(builder));
    }

    @Override
    public String build() {
        this.buildHasBeenCalled = true;
        return "";
    }
}