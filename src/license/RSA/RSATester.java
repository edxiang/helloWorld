package license.RSA;

import java.io.*;
import java.util.Map;

public class RSATester {

    static String publicKey;
    static String privateKey;

    static {
        try {
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            /*publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);*/
            publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCX0Ss3W8USX6TqQCQ70r56Dtv1HCI/ehCCh3YD\n"
                    + "h6gon40GSKg4mm0MWm25mhvvlZgFQJTrp9WZRAeaQPd8U6QzywbSb03T7qV+VdUkBa91FY7NLFOZ\n"
                    + "FMl4Jchca1RADkB/JS56ONWjzIm75MMHqqTibx6ZHvUQXuOQGYsoKdyG+wIDAQAB";

            privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJfRKzdbxRJfpOpAJDvSvnoO2/Uc\n"
                        + "Ij96EIKHdgOHqCifjQZIqDiabQxabbmaG++VmAVAlOun1ZlEB5pA93xTpDPLBtJvTdPupX5V1SQF\n"
                        + "r3UVjs0sU5kUyXglyFxrVEAOQH8lLno41aPMibvkwweqpOJvHpke9RBe45AZiygp3Ib7AgMBAAEC\n"
                        + "gYBUtmGP9UQk+XuTPpE5VGH2x73Sqo0tsFXwD9g5JgQeDtFpNTewxfKdVwQs8aIu8OEv5RZz3GXi\n"
                        + "rMQ1PZUbKazQYOGaQdJKVDrnBIx/PW/oiwbq4VcHrPMhcYRT793gZPW+rXArPgtTYi4Ctl7R8EiE\n"
                        + "k4nHs2SaFVIoFGaxVwb44QJBANbWmMhSrtKlcByQV3/Bg4tdmScbyxfCr4CmLYf2p/lIXHiRLTn2\n"
                        + "I1hEsGg8d6c5h7kHxvfD2cPXV3opsNeZxDECQQC054DfPWyfWvY8qQ3WhI05PhsP2jG+wjuC2pYS\n"
                        + "2d8aT0XUTuQLCvqJ61zX2ZfIfHp8arSv2msPiKbR6y5Zts7rAkEA0gNLrR/umCpzUujjMBc6gUVJ\n"
                        + "DssDmMGPEKLiBXRgNba/9nhsjqmHWaUkEXFywjzh6UWqAdApk2FxuRECN3CwMQJAW2GJzrrHcOPQ\n"
                        + "+KlozRDeCaleoC5W7IZO63WhU1ptAWxD2NAVD6L3Fc4ncv1+V47RjKGWLjKF3C3qHqXPHxBiCwJB\n"
                        + "AKrqyppd+0LL1noC8AtFNoh3FQxDI+rvjfczOoNYk+qgSMgFQfdViwalESmwqtbNdBleZ/u+7aRs\n"
                        + "YFxiia7J14w=";
            /*System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        test();
        //testSign();
    }

    static void test() throws Exception {
        System.err.println("公钥加密——私钥解密");

        InputStream is = new FileInputStream(new File("license123"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while((len = is.read(b)) != -1){
            baos.write(b,0,len);
        }
        byte[] encodedData = baos.toByteArray();
        baos.close();

        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
        String target = new String(decodedData);
        System.out.println("解密后文字: \r\n" + target);
    }

    static void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);
        System.out.println("加密后：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);
        String target = new String(decodedData);
        System.out.println("解密后: \r\n" + target);
        System.err.println("私钥签名——公钥验证签名");
        String sign = RSAUtils.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);
        boolean status = RSAUtils.verify(encodedData, publicKey, sign);
        System.err.println("验证结果:\r" + status);
    }

    static void readAndEncript() throws Exception{
        InputStreamReader is = new InputStreamReader(new FileInputStream("license-"));
        BufferedReader bis = new BufferedReader(is);
        String s;
        StringBuffer temp = new StringBuffer("");
        while ((s = bis.readLine()) != null) {
            temp.append(s + "\n");
        }
        bis.close();
        is.close();

        String source =temp.toString();
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
        System.out.println("加密后文字：\r\n" + new String(encodedData));

        OutputStream os = new FileOutputStream(new File("license"));
        os.write(encodedData);
        os.close();
    }

}