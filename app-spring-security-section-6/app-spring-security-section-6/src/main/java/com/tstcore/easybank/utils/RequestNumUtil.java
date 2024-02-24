package com.tstcore.easybank.utils;

import java.util.Random;

public class RequestNumUtil {
    public static String getServiceRequestNumber() {
        Random random = new Random();
        int randNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ randNum;
    }
}
