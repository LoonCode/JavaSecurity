package com.loon.algorithm;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * Created by Administrator on 2015/9/8.
 */
public class SHA {

    /**
     * SHAº”√‹
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {

        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(data);

        return sha.digest();

    }


    public static void main(String[] args) throws Exception {

        BigInteger sha = new BigInteger(encryptSHA("123".getBytes(Charset.defaultCharset())));

        System.out.println(sha.toString(32));
    }

}


