package utils;

import java.io.*;

/**
 * @Author guc
 * @Date 2019/11/18 16:12
 * @Description TODO
 */
public class Util {
    /**
     * typeName... parameterName 可变参数
     *
     * @param numbers 参数
     * @return 最大值
     */
    public static double getMax(double... numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        double max = numbers[0];
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static class FileUtils {
        /**
         * 读取文件
         *
         * @param path 文件路径
         * @return 文件内容
         */
        public static String readFile2String(String path) {
            File file = new File(path);
            StringBuilder sb = new StringBuilder();
            try {
                FileInputStream is = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append("\r\n");
                }
                reader.close();
                inputStreamReader.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
                if (!file.exists())
                    sb.append("File not found");
            }
            return sb.toString();
        }

        /**
         * 写入文件
         *
         * @param filePath 文件路径
         * @param content  内容
         * @param append   是否拼接
         * @return 是否写入成功
         */
        public static boolean writeString2File(String filePath, String content, boolean append) {
            boolean success = true;
            File file = new File(filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                FileOutputStream fop = new FileOutputStream(file, append);//拼接
                OutputStreamWriter writer = new OutputStreamWriter(fop);//new OutputStreamWriter(fop, "UTF-8"); 指定编码，Windows默认gbk
                writer.append(content);
                writer.close();
                fop.close();
            } catch (IOException e) {
                e.printStackTrace();
                success = false;
            }
            return success;
        }
    }
}
