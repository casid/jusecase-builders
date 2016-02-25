package org.jusecase.builders.builders.collections;

import org.junit.Test;
import org.jusecase.builders.ErrorTest;
import org.jusecase.builders.Newable;
import org.jusecase.builders.When;
import org.jusecase.builders.newables.NewableArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ImmutableCollectionBuilderTest extends ErrorTest {
    private final ImmutableCollectionBuilder<String, List<String>> builder = new ImmutableCollectionBuilder<String, List<String>>(new NewableArrayList<String>());
    private final List<String> list1 = new ArrayList<String>(Arrays.asList("1", "2"));
    private final List<String> list2 = new ArrayList<String>(Arrays.asList("3", "4", "5"));

    @Test
    public void testBuildResultIsNotNullAfterConstruction() throws Exception {
        assertNotNull(builder.build());
    }

    @Test
    public void testBuildResultIsEmptyAfterConstruction() throws Exception {
        assertTrue(builder.build().isEmpty());
    }

    @Test
    public void testBuildResultIsUnmodifiableAfterConstruction() throws Exception {
        when(new When() {
            @Override
            public void isExecuted() {
                builder.build().add("");
            }
        });

        thenErrorIs(UnsupportedOperationException.class);
    }

    @Test
    public void testOutputCollectionIsNotSameInstanceAsInputCollection() throws Exception {
        final ImmutableCollectionBuilder<String, List<String>> builder = this.builder.with(list1);
        final int expected = list1.size();
        assertEquals(expected, builder.build().size());
        list1.add("3");
        assertEquals(expected, builder.build().size());
    }

    @Test
    public void testOutputCollectionStaysTheSameAfterManyBuildCalls() throws Exception {
        final Collection<String> immutable = builder.build();
        assertSame(immutable, builder.build());
        assertSame(immutable, builder.build());
    }

    @Test
    public void testOutputCollectionIsUnmodifiable() throws Exception {
        final ImmutableCollectionBuilder<String, List<String>> builder = this.builder.with(list1);
        when(new When() {
            @Override
            public void isExecuted() {
                builder.build().add("");
            }
        });

        thenErrorIs(UnsupportedOperationException.class);
    }

    @Test
    public void testCallingWithReturnsNewBuilderInstance() throws Exception {
        assertNotSame(builder.with(list1), builder);
    }

    @Test
    public void testCallingWithWontMutateCurrentInstance() throws Exception {
        assertEquals(0, builder.build().size());
        builder.with(list1);
        assertEquals(0, builder.build().size());
    }

    @Test
    public void testConstructingBuilderWithNullParamResultsInNPE() throws Exception {
        whenBuilderIsConstructedWith(null);
        thenErrorIs(NullPointerException.class);
    }

    @Test
    public void testCallingWithWillAggregateBuildResult() throws Exception {
        final int expected = list1.size() + list2.size();
        assertEquals(expected, builder.with(list1).with(list2).build().size());
    }

    private void whenBuilderIsConstructedWith(final Newable<List<String>> listNewable) {
        when(new When() {
            @Override
            public void isExecuted() {
                new ImmutableCollectionBuilder<String, List<String>>(listNewable);
            }
        });
    }
}