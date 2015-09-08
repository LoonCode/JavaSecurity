package com.loon.algorithm;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2015/9/8.
 */
public class BASE64 {

    /**
     * BASE64Ω‚√‹
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64º”√‹
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    public static void main(String[] args) throws Exception {

        String  test="123";
        String  encryptTest="";
        encryptTest =encryptBASE64(test.getBytes(Charset.defaultCharset()));
        System.out.println(encryptTest);
        System.out.println(new String(decryptBASE64(encryptTest)));



    }

}
