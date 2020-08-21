package aes;

import org.apache.commons.codec.binary.Base64;

/**
 * @Author: guc
 * @Description: 封装对外访问方法
 * @Date: 2020/8/20 19:27
 * @Version: 1.0
 */
public class WXCore {
    private static final String WATERMARK = "watermark";
    private static final String APPID = "appid";

    /**
     * 解密数据
     *
     * @return
     * @throws Exception
     */
    public static String decrypt(String appId, String encryptedData, String sessionKey, String iv) {
        String result = "";
        try {
            AES aes = new AES();
            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
            if (null != resultByte && resultByte.length > 0) {
                result = new String(WxPKCS7Encoder.decode(resultByte));
//                JSONObject jsonObject = new Gson().fromObject(result);
//                String decryptAppid = jsonObject.getJSONObject(WATERMARK).getString(APPID);
//                if(!appId.equals(decryptAppid)){
//                    result = "";
//                }
            }
        } catch (Exception e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        String appId = "wx4f4bc4dec97d474b";
        String encryptedData = "qePU86UJhGcGamByYH23FZgon2bKHwItzpigEbGLWmVrsgUFHZ8jePI2CAzGU0GSZCAyuNJBzK7TjPrW627Elvuna0naYRdPrbF+SGavg/hvTr5FXI09dN69BN3sFbGw7A42ZmJTWhCJ4nAZVzaenYkDsEPwCESmo059y/dncXHg8Bykh1oHtsyhvn9wWZse3qVXowR2KfF9jtl+2U6AyzkgblPsVuY1bJRS95APOVgbPw2Byp0tXF+BwA4v+BKfGjXvaDz1IrDZ/RpxjE9zKZtDn7D6Jv6NQ3feaa5XuA07f97+g3TGKyZ316TsNv6F10rErWkctiJUnpr96Xh3BVSJtG5jEiBtv19TTeehmytxm3wZWvVmpxY652WOvHTJceRaf3PzbIcfVtK1hGKIIpsHJK0uB+6B+yeb7NOqQkcWTxuVmfSaW+T9ozfXOURl27oP7/jGSOymZx6aIO4AxQ==";
        String sessionKey = "oVHI8CO5yCUkzj7e63sGOg==";
        String iv = "D8sSmmxMV9cCJmQr7zblbw==";
        System.out.println(decrypt(appId, encryptedData, sessionKey, iv));
    }
}
