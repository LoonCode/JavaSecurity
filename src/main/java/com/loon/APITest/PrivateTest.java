package com.loon.APITest;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.channels.Channels;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2015/9/11.
 */
public class PrivateTest {


    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        String str="123";
        byte[] plainText=str.getBytes("UTF8");
        
        //ͨ��KeyGenerator�γ�һ��key
        System.out.println("Start generate AES key");
        KeyGenerator keyGen=KeyGenerator.getInstance("AES");
        keyGen.init(128);
        Key key=keyGen.generateKey();
        System.out.println("Finish generating DES key");

        //���һ��˽�_������Cipher��ECB�Ǽ��ܷ�ʽ��PKCS5Padding����䷽��
        Cipher cipher= Cipher.getInstance("AES/ECB/PKCS5Padding");
        System.out.println(""+cipher.getProvider().getInfo());

        //ʹ��˽�_����
        System.out.println("Start encryption:");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] cipherText=cipher.doFinal(plainText);
        System.out.println("Finish encryption:");
        System.out.println(new String(cipherText, StandardCharsets.UTF_8));
        System.out.println(new BigInteger(cipherText));



        //ʹ��˽�_����

        System.out.println("Start decryption:");
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] newPlainText=cipher.doFinal(cipherText);
        System.out.println("Finish decryption:");

        System.out.println(new String(newPlainText,"UTF8"));
    }

}
