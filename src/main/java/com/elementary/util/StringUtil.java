package com.elementary.util;

public final class StringUtil {

    private StringUtil() {
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }
}
