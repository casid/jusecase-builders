package org.jusecase.builders.builders.structures;

import org.junit.Test;
import org.jusecase.builders.ErrorTest;
import org.jusecase.builders.Newable;
import org.jusecase.builders.When;
import org.jusecase.builders.builders.collections.CopyCollectionBuilder;
import org.jusecase.builders.newables.NewableArrayList;
import org.jusecase.builders.newables.NewableCollection;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayBuilderTest extends ErrorTest {
    private final ArrayBuilder<String> builder = new ArrayBuilder<String>(new String[0]);
    private final String[] array1 = {"1", "2"};
    private final String[] array2 = {"3", "4", "5"};

    @Test
    public void testConstructionWithNullParamThrowsNPE() throws Exception {
        when(new When() {
            @Override
            public void isExecuted() {
                new ArrayBuilder<String>(null);
            }
        });
        thenErrorIs(NullPointerException.class);
    }

    @Test
    public void testBuildResultIsNotNullAfterConstruction() throws Exception {
        assertNotNull(builder.build());
    }

    @Test
    public void testBuildResultIsEmptyAfterConstruction() throws Exception {
        assertTrue(builder.build().length == 0);
    }

    @Test
    public void testCallingBuildWillReturnACopy() throws Exception {
        final String[] buildResult = builder.build();
        assertNotSame(buildResult, builder.build());
    }

    @Test
    public void testCallingWithReturnNewBuilderInstance() throws Exception {
        final ArrayBuilder<String> builderCopy = builder.with(array1);
        assertNotSame(builderCopy, builder);
    }

    @Test
    public void testCallingWithWontMutateCurrentInstance() throws Exception {
        assertEquals(0, builder.build().length);
        builder.with("1", "2");
        assertEquals(0, builder.build().length);
    }

    @Test
    public void testCallingWithWillNotAggregateBuildResult() throws Exception {
        final ArrayBuilder<String> builder = this.builder.with(array1);
        assertEquals(array1.length, builder.build().length);
        assertEquals(array2.length, builder.with(array2).build().length);
    }
}