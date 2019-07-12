package site.yanyan.learn.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64Util {

    public static String encode(String text) {
        try {
            return new BASE64Encoder().encode(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String decode(String text) {
        try {
            return new String(new BASE64Decoder().decodeBuffer(text), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
