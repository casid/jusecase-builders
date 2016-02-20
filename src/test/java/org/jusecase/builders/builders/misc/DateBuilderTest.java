package org.jusecase.builders.builders.misc;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jusecase.builders.ErrorTest;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(ZohhakRunner.class)
public class DateBuilderTest extends ErrorTest{
    private final DateBuilder builder = new DateBuilder();
    private final String dateString = "2016-01-01 00:00:01";
    private final String dateString2 = "2017-01-01 00:00:01";

    @Test
    public void testBuildResultIsNotNullAfterConstruction() throws Exception {
        assertNotNull(builder.build());
    }

    @Test
    public void testCallingBuildWillReturnACopy() throws Exception {
        final Date buildResult = builder.build();
        assertNotSame(buildResult, builder.build());
    }

    @Test
    public void testCallingWithReturnNewBuilderInstance() throws Exception {
        final DateBuilder builderCopy = builder.with(dateString);
        assertNotSame(builderCopy, builder);
    }

    @Test
    public void testCallingWithWontMutateCurrentInstance() throws Exception {
        Date date = builder.build();
        builder.with(dateString2);
        assertTrue(date.getTime() == builder.build().getTime());
    }

    @TestWith({
            "2016-01-01 00:00",
            "2016-01-01 00",
            "2016-01-01",
    })
    public void testWithThrowsNPE(final String invalidDateFormatString) throws Exception {
        try{
            builder.with(invalidDateFormatString);
            fail("no exception has been thrown");
        } catch(ParseException e){
            assertTrue(true);
        }
    }

    @TestWith({
            "2016-01-01 00:00:01",
    })
    public void testWith(final String validDateFormatString) throws Exception {
        try{
            builder.with(validDateFormatString);
            assertTrue(true);
        } catch(ParseException e){
            fail("no exception has been thrown");
        }
    }
}