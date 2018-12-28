package com.goldmantis.process.lechange.util;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class HttpSendSetParam extends HttpSend {

    public static Object sent(HashMap<String, Object> paramMap, String method) {

        HttpSend.setHost(CONST.HOST + ":" + CONST.PORT);
        // super.setTime(time);
        HttpSend.setAppId(CONST.APPID);
        HttpSend.setAppSecret(CONST.SECRET);
        HttpSend.setPhone(CONST.PHONE);
        HttpSend.setVer("1.0");
        HttpSend.setNonce(UUID.randomUUID().toString());
        Random rand = new Random(); 
        int i = rand.nextInt(10000);
        HttpSend.setId(String.valueOf(i));

        return HttpSendMethod(paramMap, method);
    }
}
