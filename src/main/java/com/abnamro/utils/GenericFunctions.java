package com.abnamro.utils;

import java.util.Base64;
import java.util.Calendar;

public class GenericFunctions {
    public static String getUniqueName(String sName) {
        Calendar rightNow = Calendar.getInstance();
        String sNewName = sName + rightNow.get(Calendar.YEAR)
                + rightNow.get(Calendar.MONTH)
                + rightNow.get(Calendar.DAY_OF_MONTH)
                + rightNow.get(Calendar.HOUR)
                + rightNow.get(Calendar.MINUTE)
                + rightNow.get(Calendar.SECOND);
        return sNewName;
    }

    public static String base64Encoder(String sUsername, String sPassword) {
        return Base64.getEncoder().encodeToString((sUsername + ":" + sPassword).getBytes());
    }
}
