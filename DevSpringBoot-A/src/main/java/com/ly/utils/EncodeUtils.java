package com.ly.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeUtils {
    //加密种类：1、MD5:单向加密；2、SHA:单向加密；3、DES：单向或双向

    private static final String[] digital = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * 获取加密字符串
     * @param plaintext
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String getMd5Encode(String plaintext) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String finalPlaintext = initMd5Encode(initMd5Encode(initMd5Encode(plaintext) + "lychee.wang") + "lychee.wang");
        return finalPlaintext;
    }

    /**
     * 初始化加密程序
     * @param plaintext
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static String initMd5Encode(String plaintext) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //MD5是固定写法，否则会抛异常
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //明文加密(获得的bytes永远为16位)
        byte[] bytes = md5.digest(plaintext.getBytes("UTF-8"));
        //密文串
        String ciphertext = "";
        //for循环每次从 digital 中取出2个元素参与加密
        for(byte bt : bytes){
            int vbt = bt;
            if(vbt < 0)
                vbt = vbt + 256;

            int indx0 = vbt / 16;
            int indx1 = vbt % 16;
            ciphertext += digital[indx0] + digital[indx1];
        }
        return ciphertext;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(getMd5Encode("546546"));
    }
}
