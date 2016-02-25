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

public class UnmodifiableCollectionBuilderTest extends ErrorTest {
    private final UnmodifiableCollectionBuilder<String, List<String>> builder = new UnmodifiableCollectionBuilder<String, List<String>>(new NewableArrayList<String>());
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
    public void testOutputCollectionIsSameInstanceAsInputCollection() throws Exception {
        final UnmodifiableCollectionBuilder<String, List<String>> builder = this.builder.with(list1);
        final int expected = list1.size();
        assertEquals(expected, builder.build().size());
        list1.add("3");
        assertEquals(expected+1, builder.build().size());
    }

    @Test
    public void testOutputCollectionIsUnmodifiable() throws Exception {
        final UnmodifiableCollectionBuilder<String, List<String>> builder = this.builder.with(list1);
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

    private void whenBuilderIsConstructedWith(final Newable<List<String>> listNewable) {
        when(new When() {
            @Override
            public void isExecuted() {
                new UnmodifiableCollectionBuilder<String, List<String>>(listNewable);
            }
        });
    }
}