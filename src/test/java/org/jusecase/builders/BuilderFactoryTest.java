package org.jusecase.builders;

import org.junit.Test;
import org.jusecase.builders.builders.collections.*;
import org.jusecase.builders.newables.NewableArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.jusecase.builders.BuilderFactory.*;
import static org.jusecase.builders.Builders.a;

public class BuilderFactoryTest {

    @Test
    public void testInstanceIsNotNull() {
        instanceCanBeBuilt(createCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createCopyCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createAggregateCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createUnmodifiableCollectionBuilder(new NewableArrayList<Object>()));
        instanceCanBeBuilt(createImmutableCollectionBuilder(new NewableArrayList<Object>()));
    }

    @Test
    public void testBuilderEqualsClass() throws Exception {
        builderEqualsClass(createCollectionBuilder(new NewableArrayList<Object>()), CollectionBuilder.class, "createCollectionBuilder failed");
        builderEqualsClass(createCopyCollectionBuilder(new NewableArrayList<Object>()), CopyCollectionBuilder.class, "createCopyCollectionBuilder failed");
        builderEqualsClass(createAggregateCollectionBuilder(new NewableArrayList<Object>()), AggregateCollectionBuilder.class, "createAggregateCollectionBuilder failed");
        builderEqualsClass(createUnmodifiableCollectionBuilder(new NewableArrayList<Object>()), UnmodifiableCollectionBuilder.class, "createUnmodifiableCollectionBuilder failed");
        builderEqualsClass(createImmutableCollectionBuilder(new NewableArrayList<Object>()), ImmutableCollectionBuilder.class, "createImmutableCollectionBuilder failed");
    }

    @Test
    public void testBuilderIsNotNull() {
        assertNotNull(createCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createCopyCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createAggregateCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createUnmodifiableCollectionBuilder(new NewableArrayList<Object>()));
        assertNotNull(createImmutableCollectionBuilder(new NewableArrayList<Object>()));
    }

    private <T> void instanceCanBeBuilt(Builder<T> builder) {
        T instance = a(builder);
        assertNotNull(instance);
    }

    private <T, R> void builderEqualsClass(Builder<T> builder, Class<R> expectedClass, String message) {
        assertTrue(message, expectedClass.isInstance(builder));
    }
}