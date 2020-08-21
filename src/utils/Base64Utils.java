package utils;

import java.io.*;
import java.util.Base64;

/**
 * @Author: guc
 * @Description: 图片Base64处理工具
 * @Date: 2020/8/14 11:08
 * @Version: 1.0
 */
public class Base64Utils {
    /**
     * @param path 文件路径
     * @return base64字符串
     */
    public static String picture2Base64(String path) {
        File file = new File(path);
        String base64 = "";
        FileInputStream inputStream = null;
        ByteArrayOutputStream out = null;
        try {
            inputStream = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 4];
            int n = 0;
            while ((n = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            byte[] pics = out.toByteArray();
            base64 = Base64.getEncoder().encodeToString(pics);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return "FileNotFoundException";
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return base64;
    }

    /**
     * @param base64   base64字符串
     * @param filePath 保存文件路径
     * @return 保存的文件
     */
    public static File base642Picture(String base64, String filePath) {
        File file = new File(filePath);
        FileOutputStream out = null;
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            out = new FileOutputStream(file);
            byte[] picBytes = Base64.getDecoder().decode(base64);
            out.write(picBytes);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
}


