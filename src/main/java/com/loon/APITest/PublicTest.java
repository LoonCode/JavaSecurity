package com.loon.APITest;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * Created by Administrator on 2015/9/11.
 */
public class PublicTest {

    public static void main(String[] args) throws Exception{
         String str="123";
        byte[] plainText=str.getBytes("UTF8");
        //构成一个RSA密钥
        System.out.println("Start generating RSA key");
        KeyPairGenerator keyGen=KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair key=keyGen.generateKeyPair();
        System.out.println("Private Key " +new BigInteger(key.getPrivate().getEncoded()).toString(32));
        System.out.println("Public Key " +new BigInteger(key.getPublic().getEncoded()).toString(32));
        System.out.println("Finish generating RSA key");

        //获得一个RSA的Cipher类，使用公鈅加密
        Cipher cipher=Cipher.getInstance("RSA/ECB/PKCS1Padding");
        System.out.println(""+cipher.getProvider().getInfo());

        System.out.println("Start encryption");
        cipher.init(Cipher.ENCRYPT_MODE,key.getPublic());
        byte[] cipherText=cipher.doFinal(plainText);
        System.out.println("Finish encryption:");
        System.out.println(new String(cipherText,"UTF8"));


        //使用私鈅解密
        System.out.println("Start decryption");
        cipher.init(Cipher.DECRYPT_MODE,key.getPrivate());
        byte[] newPlainText=cipher.doFinal(cipherText);
        System.out.println("Finish decryption:");
        System.out.println(new String(newPlainText,"UTF8"));

    }
}
