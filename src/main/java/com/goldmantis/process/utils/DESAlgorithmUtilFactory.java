package com.goldmantis.process.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by E0100437 on 2017/2/23.
 */
public class DESAlgorithmUtilFactory {

//    private static String Algorithm = "DESede";
    private static String Algorithm = "DES/ECB/PKCS5Padding";

//    private static final String Default_Key = "A3F2DEI569WBCJSJEOTY45DYQWF68H1Y";
    private static final String Default_Key = "T@ngL@ng";

    public static String encryptString(String value) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return encryptString(Default_Key, value);
    }


    public static String encryptString(String key, String value) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        byte[] bytesKey = null, bytes = null, bytesCipher = null;
        SecretKey deskey = null;
        if (value == null)
            new IllegalArgumentException("待加密字串不允许为空");
        //密码器
        Cipher desCipher = Cipher.getInstance(Algorithm);
        try{
            bytesKey = key.getBytes("UTF-8");
            deskey = new SecretKeySpec(bytesKey, "DES");
            bytes = value.getBytes();//待解密的字串
            desCipher.init(Cipher.ENCRYPT_MODE, deskey);//初始化密码器，用密钥deskey,进入解密模式
            bytesCipher = desCipher.doFinal(bytes);
            return new String(Base64.encodeBase64(bytesCipher), "UTF-8").trim();
        }
        finally{
            bytesKey = null;
            bytes = null;
            bytesCipher = null;
        }
    }

    public static String decryptString(String value) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        return decryptString(Default_Key, value);
    }

    public static String decryptString(String key, String value) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        byte[] bytesKey = null, bytes = null, bytesCipher = null;
        SecretKey deskey = null;
        if (value == null)
            new IllegalArgumentException("待解密字串不允许为空");
        //密码器
        Cipher desCipher = Cipher.getInstance(Algorithm);
        try{
            bytesKey = key.getBytes("UTF-8");
            deskey = new SecretKeySpec(bytesKey, "DES");
            bytes = Base64.decodeBase64(value.getBytes("UTF-8"));//加密后的字串
            desCipher.init(Cipher.DECRYPT_MODE, deskey);//初始化密码器，用密钥deskey,进入解密模式
            bytesCipher = desCipher.doFinal(bytes);
            return (new String(bytesCipher,"UTF-8"));
        }
        finally{
            bytesKey = null;
            bytes = null;
            bytesCipher = null;
        }
    }
    public static void main(String args[]){
        try{
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
