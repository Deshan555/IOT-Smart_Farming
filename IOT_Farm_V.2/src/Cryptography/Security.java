package Cryptography;

import javax.crypto.KeyGenerator;

import javax.crypto.SecretKey;

import java.math.BigInteger;

import java.security.NoSuchAlgorithmException;

public class Security
{
    public static String key_gen() throws NoSuchAlgorithmException
    {
        KeyGenerator gen = KeyGenerator.getInstance("AES");

        gen.init(128);

        SecretKey secretKey = gen.generateKey();

        byte[] binary = secretKey.getEncoded();

        String key = String.format("%032X",new BigInteger(+1,binary));

        System.out.println(key);

        return key;
    }
}
