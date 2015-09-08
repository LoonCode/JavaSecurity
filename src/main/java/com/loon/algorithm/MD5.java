package com.loon.algorithm;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * Created by Administrator on 2015/9/8.
 */
public class MD5 {

    /**
     * MD5º”√‹
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(data);

        return md5.digest();

    }


    public static void main(String[] args) throws Exception {
        BigInteger md5 = new BigInteger(encryptMD5("123".getBytes(Charset.defaultCharset())));
        System.out.println(md5.toString(16));
    }

}
