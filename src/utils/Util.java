package utils;

import bean.MyObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        /**
         * 从文件中读取对象
         *
         * @param filePath
         * @param <T>
         * @return
         */
        public static <T> List<T> readFile2Object(String filePath) {
            List<T> datas = new ArrayList<>();
            File file = new File(filePath);
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                T obj;
                while ((obj = (T) ois.readObject()) != null) {
                    datas.add(obj);
                }
                ois.close();
                fis.close();
            } catch (IOException e) {
                if (e instanceof EOFException) {
                    System.out.println("对象读取完毕");
                } else {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return datas;
        }

        /**
         * 将对象写入文件
         *
         * @param filePath 文件路径
         * @param obj      对象
         * @param append   是否拼接
         * @param <T>
         * @return
         */
        public static <T> boolean writeObject2File(String filePath, T obj, boolean append) {
            boolean success = true;
            File file = new File(filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                FileOutputStream fop = new FileOutputStream(file, append);//拼接
                ObjectOutputStream oos;
                if (append && file.length() > 0) {//追加 且已存有对象
                    oos = new MyObjectOutputStream(fop);
                } else {
                    oos = new ObjectOutputStream(fop);
                }
                oos.writeObject(obj);
                oos.close();
                fop.close();
            } catch (IOException e) {
                e.printStackTrace();
                success = false;
            }
            return success;
        }
    }
}
