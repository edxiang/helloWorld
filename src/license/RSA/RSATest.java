package license.RSA;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by Kevin.Z on 2017/7/27.
 */
public class RSATest {

    public static void main(String[] args) {
        try {
            RSATest encrypt = new RSATest();

            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(1024);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            String str = "Hello World!";
            System.out.println("String will be encrypted: " + str);
            byte[] e = encrypt.encrypt(publicKey, str.getBytes());
            String tmp1 = encrypt.bytesToString(e);
            System.out.println("encrypted String's bytes, use bytesToString() method convert bytes to string:  "
                    + tmp1);
            String[] strArr = tmp1.split(" ");
            int len = strArr.length;
            byte[] clone = new byte[len];
            for (int i = 0; i < len; i++) {
                clone[i] = Byte.parseByte(strArr[i]);
            }
            System.out.println("convert to String, then back to bytes again: " + encrypt.bytesToString(clone));
            byte[] d = encrypt.decrypt(privateKey, clone);
            System.out.println("decrypted String's bytes, use bytesToString() method convert bytes to string:"
                    + encrypt.bytesToString(d));
            System.out.println("construct a string by decrypted string's bytes: " + new String(d));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String bytesToString(byte[] encrytpByte) {
        String result = "";
        for (Byte bytes : encrytpByte) {
            result += bytes.toString() + " ";
        }
        return result;
    }

    protected byte[] encrypt(RSAPublicKey publicKey, byte[] obj) {
        if (publicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                return cipher.doFinal(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected byte[] decrypt(RSAPrivateKey privateKey, byte[] obj) {
        if (privateKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
                return cipher.doFinal(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}