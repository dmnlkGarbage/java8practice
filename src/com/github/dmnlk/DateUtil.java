package com.github.dmnlk;

import java.sql.Timestamp;

/**
 * @author dmnlk
 */
public class DateUtil {
    public Timestamp getNowTimestamp() {
        return  new Timestamp(System.currentTimeMillis());
    }
}
