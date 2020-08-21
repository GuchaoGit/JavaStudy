package utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

/**
 * @Author: guc
 * @Description: AES 加密/解密
 * @Date: 2020/8/20 14:37
 * @Version: 1.0
 */
public class AesUtils {
    private static final String MODE = "AES";//加密模式
    private static final String PADDING_MODE = "AES/CBC/PKCS7Padding";//加密模式
    private static final Charset CHARSET = Charset.forName("utf-8");
    private static final int BLOCK_SIZE = 32;
    public static boolean initialized = false;
    private static String IV_STRING = "sdf4ddfsFD86Vdf2";//偏移量 ecb模式不用
    private static String ENCODING = "UTF-8"; //字符集
    private static String KEY = "guchao19910124..";//密码

    public static void main(String[] args) {

        /*
        String text = "guchaochao";
        String encrypt = encrypt(text);
        System.out.println(text +"加密后：" + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("解密后："+decrypt);

         */
        String encryptedData = "etH8eRyxFCDizuM9J+DkCp432PT/ECRdefvunVVEXDpsMHHfUbkyPoC+QKG9tW8yY25jck7xmTkUOTOxBGoMm7ebpzGOGqRtRW9CI8ivnCoWQQQJeHk+/7MYZam5ujpOGmM1vBeBlq4ISrKWXXgvBBqeaSgLW0DA+5B3g310S5STPCwX/J+RV6GpmzhXrQprr8dWH9jgXO+LgXYhTOduCA==";
        String sessionKey = "aFOJlTRh/4zERyIEYyk2+w==";
        String iv = "TR5El5mOix7CFITt36BuHA==";

        String result = decrypt(encryptedData, sessionKey, iv);
        System.out.println(result);
        System.out.println("原：" + encryptedData);
        String res = encrypt(result, sessionKey, iv);
        System.out.println("新：" + res);

    }

    /**
     * 加密
     *
     * @param content
     * @return
     */
    public static String encrypt(String content) {
        String result = null;
        try {
            byte[] byteContent = content.getBytes(ENCODING);
            byte[] key = KEY.getBytes(ENCODING);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, MODE);
            byte[] initParam = IV_STRING.getBytes(ENCODING);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance(PADDING_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encryptedBytes = cipher.doFinal(byteContent);
            //进行base64 编码
            result = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String decrypt(String content) {
        String result = null;
        try {
            byte[] byteContent = Base64.getDecoder().decode(content); //base64解码
            byte[] key = KEY.getBytes(ENCODING);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, MODE);
            byte[] initParam = IV_STRING.getBytes(ENCODING);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance(PADDING_MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decryptBytes = cipher.doFinal(byteContent);
            result = new String(decode(decryptBytes));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 加密工具
     *
     * @param content
     * @param keyBase64
     * @param ivBase64
     * @return
     */
    public static String encrypt(String content, String keyBase64, String ivBase64) {
        initialize();
        String result = null;
        try {
            byte[] byteContent = content.getBytes(ENCODING);
            byte[] key = Base64.getDecoder().decode(keyBase64);
            byte[] iv = Base64.getDecoder().decode(ivBase64);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, MODE);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance(PADDING_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encryptedBytes = cipher.doFinal(byteContent);
            //进行base64 编码
            result = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解密工具
     *
     * @param content
     * @param keyBase64
     * @param ivBase64
     * @return
     */
    public static String decrypt(String content, String keyBase64, String ivBase64) {
        initialize();
        String result = null;
        try {
            byte[] byteContent = Base64.getDecoder().decode(content); //base64解码
            byte[] key = Base64.getDecoder().decode(keyBase64);
            byte[] iv = Base64.getDecoder().decode(ivBase64);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, MODE);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance(PADDING_MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decryptBytes = cipher.doFinal(byteContent);
            result = new String(decode(decryptBytes));
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获得对明文进行补位填充的字节.
     *
     * @param count 需要进行填充补位操作的明文字节个数
     * @return 补齐用的字节数组
     */
    private static byte[] encode(int count) {
        // 计算需要填充的位数
        int amountToPad = BLOCK_SIZE - (count % BLOCK_SIZE);
        if (amountToPad == 0) {
            amountToPad = BLOCK_SIZE;
        }
        // 获得补位所用的字符
        char padChr = chr(amountToPad);
        String tmp = new String();
        for (int index = 0; index < amountToPad; index++) {
            tmp += padChr;
        }
        return tmp.getBytes(CHARSET);
    }

    /**
     * 删除解密后明文的补位字符
     *
     * @param decrypted 解密后的明文
     * @return 删除补位字符后的明文
     */
    private static byte[] decode(byte[] decrypted) {
        int pad = decrypted[decrypted.length - 1];
        if (pad < 1 || pad > 32) {
            pad = 0;
        }
        return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
    }

    /**
     * 将数字转化成ASCII码对应的字符，用于对明文进行补码
     *
     * @param a 需要转化的数字
     * @return 转化得到的字符
     */
    private static char chr(int a) {
        byte target = (byte) (a & 0xFF);
        return (char) target;
    }

    private static void initialize() {
        if (initialized)
            return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }
}
