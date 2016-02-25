package org.jusecase.builders.builders.collections;

import org.junit.Test;
import org.jusecase.builders.ErrorTest;
import org.jusecase.builders.Newable;
import org.jusecase.builders.When;
import org.jusecase.builders.newables.NewableArrayList;

import java.util.List;

import static junit.framework.Assert.*;

public class CollectionBuilderTest extends ErrorTest{
    private final CollectionBuilder<String, List<String>> builder = new CollectionBuilder<String, List<String>>(new NewableArrayList<String>());
    private final String[] list1 = {"1", "2"};
    private final String[] list2 = {"3", "4", "5"};

    @Test
    public void testBuildResultIsNotNullAfterConstruction() throws Exception {
        assertNotNull(builder.build());
    }

    @Test
    public void testBuildResultIsEmptyAfterConstruction() throws Exception {
        assertTrue(builder.build().isEmpty());
    }

    @Test
    public void testCallingBuildWillReturnACopy() throws Exception {
        final List<String> buildResult = builder.build();
        assertNotSame(buildResult, builder.build());
    }

    @Test
    public void testCallingWithReturnNewBuilderInstance() throws Exception {
        final CollectionBuilder<String, List<String>> builderCopy = builder.with(list1);
        assertNotSame(builderCopy, builder);
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
        final int expected = list1.length + list2.length;
        assertEquals(expected, builder.with(list1).with(list2).build().size());
    }

    private void whenBuilderIsConstructedWith(final Newable<List<String>> listNewable) {
        when(new When() {
            @Override
            public void isExecuted() {
                new CollectionBuilder<String, List<String>>(listNewable);
            }
        });
    }
}