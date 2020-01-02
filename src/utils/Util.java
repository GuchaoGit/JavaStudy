package utils;

import bean.MyObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author guc
 * @Date 2019/11/18 16:12
 * @Description TODO
 */
public class Util {

    private Util() {
        throw new AssertionError();
    }
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

    /**
     * 泛型打印数组
     *
     * @param a
     * @param <T>
     */
    public static <T> void printArray(T[] a) {
        System.out.println(Arrays.toString(a));
       /* for (T element : a) {
            System.out.printf("%s ", element);
        }
        System.out.println();*/
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

    /**
     * @param originStr 字符串
     * @return 反转
     */
    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        System.out.println(originStr);
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    /**
     * 统计文件中 某个字符串出现的次数
     *
     * @param fileName 文件
     * @param word     字符串
     * @return 字符串在文件中出现的次数
     */
    public static int countWordInFile(String fileName, String word) {
        int counter = 0;
        try (FileReader fr = new FileReader(fileName)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    int index = -1;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        counter++;
                        line = line.substring(index, word.length());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return counter;
    }

    /**
     * 展示目录中文件
     *
     * @param f
     */
    public static void showDirectory(File f) {
        _walkDirectory(f, 0);
    }

    private static void _walkDirectory(File f, int level) {
        if (f.isDirectory()) {
            System.out.println(f.getAbsolutePath());
            for (File temp : f.listFiles()) {
                _walkDirectory(temp, level + 1);
            }
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }
}
