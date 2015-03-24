package com.github.dmnlk;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void testGetNowTimestamp() throws Exception {
        Timestamp nowTimestamp = DateUtil.getNowTimestamp();
        assertTrue(nowTimestamp instanceof  Timestamp);
    }

    @Test
    public void testParseTimeString() throws Exception {
        DateUtil.parseTimeString("2015-05-05");
    }
}