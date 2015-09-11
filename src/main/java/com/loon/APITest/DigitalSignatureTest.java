package com.loon.APITest;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.SignatureException;

/**
 * Created by Administrator on 2015/9/11.
 */
public class DigitalSignatureTest {

    public static void main(String[] args) throws Exception {
        String str = "123";
        byte[] plainText = str.getBytes("UTF8");
        //形成RSA公钥对
        System.out.println("Start generating RSA key");
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);

        KeyPair key = keyGen.generateKeyPair();
        System.out.println("Finish generating RSA key");
        //使用私鈅签名
        Signature sig = Signature.getInstance("SHA1WithRSA");
        sig.initSign(key.getPrivate());
        sig.update(plainText);
        byte[] signature = sig.sign();
        System.out.println(sig.getProvider().getInfo());
        System.out.println("Signature:");
        System.out.println(new String(signature, "UTF8"));

        //使用公鈅验证
        System.out.println("Start signature verification");
        sig.initVerify(key.getPublic());
        sig.update(plainText);
        try {
            if (sig.verify(signature)) {
                System.out.println("Signature verified");
            } else {
                System.out.println("Signature failed");
            }
        } catch (SignatureException e) {
            System.out.println("Signature failed");
        }
    }
}
