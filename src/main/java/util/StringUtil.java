package util;

public final class StringUtil {

    private StringUtil() {
    }

    public static boolean isNotNumeric(String strNum) {
        return !isNumeric(strNum);
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }
}
