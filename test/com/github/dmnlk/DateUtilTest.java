package com.github.dmnlk;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void testGetNowTimestamp() throws Exception {
        System.out.println(DateUtil.getNowTimestamp());
        assertTrue(true);
    }
}