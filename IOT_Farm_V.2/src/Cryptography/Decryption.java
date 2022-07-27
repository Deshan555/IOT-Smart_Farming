package Cryptography;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;

import javax.crypto.spec.IvParameterSpec;

import javax.crypto.spec.SecretKeySpec;

public class Decryption
{
    public static String decrypt(String encrypted)
    {
        String key = "aesEncryptionKey";

        String initVector = "encryptionIntVec";
        
        try
        {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));

            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            
            Core.Background.Bugs_Log.exceptions(String.valueOf(ex));  
        }

        return null;
    }
}
