package com.zander404.springandjavaerudio.utils;

import java.util.regex.Pattern;

public class NumberConverter {
    public static boolean isNumeric(String strNumber) {

        if (strNumber == null || strNumber.isEmpty()) return false;
        strNumber = strNumber.replaceAll(",", "");

        Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");

        return pattern.matcher(strNumber).matches();
    }

    public static Double toDouble(String strNumber) {
        if (strNumber == null) return 0D;

        strNumber = strNumber.replaceAll(",", ".");

        return Double.parseDouble(strNumber);

    }
}
