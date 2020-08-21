package codeCreater;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @Author: guc
 * @Description: 二维码生成配置工具
 * @Date: 2020/8/14 15:05
 * @Version: 1.0
 */
public class ACodeCreator {
    public static String URL_GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx2cbfe49c565cb7aa&secret=ecf7207864e78d748993d9f540646b98";
    public static String ACCESS_TOKEN = "";
    public static String URL_GET_ACODE = "";
    private static String URL_GET_ACODE_BASE = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=";
    private static Gson gson = new Gson();
    private static String output = "C:\\ProgramData\\YFACODE\\";

    /**
     * 初始化输出目录和二维码生成URL
     *
     * @param outputPath
     * @throws AccessTokenException
     */
    public static void init(String outputPath) throws AccessTokenException {
        trustEveryone();
        String result = "";
        BufferedReader in = null;
        try {
            URL url = new URL(URL_GET_ACCESS_TOKEN);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置通用的请求属性
            connection.setRequestMethod("GET");
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连接
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        AccessToken accessToken = gson.fromJson(result, AccessToken.class);
        ACCESS_TOKEN = accessToken.access_token;
        if (ACCESS_TOKEN.isEmpty()) throw new AccessTokenException();
        URL_GET_ACODE = URL_GET_ACODE_BASE + ACCESS_TOKEN;
        if (!outputPath.isEmpty()) {
            File file = new File(outputPath);
            boolean isExist = file.exists();
            if (isExist) {
                output = outputPath;
            } else {
                boolean isSuccess = file.mkdirs();
                if (isSuccess) output = outputPath;
            }
        } else {
            new File(output).mkdirs();
        }
    }


    /**
     * 生成二维码
     *
     * @param scene 二维码携带自定义参数
     * @param width 默认430
     *              Content-Type →image/jpeg
     *              Content-Type →application/json; encoding=utf-8
     */
    public static void createCode(String scene, int width) throws ACodeCreateException {
        if (width < 280) {
            width = 430;
        } else if (width > 1280) {
            width = 430;
        }
        PrintWriter out = null;
        InputStream in = null;
        FileOutputStream fos = null;

        JsonObject object = new JsonObject();
        object.addProperty("scene", scene);
        object.addProperty("width", width);
        String param = object.toString();
        try {
            URL realUrl = new URL(URL_GET_ACODE);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流（设置请求编码为UTF-8）
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 获取请求返回数据（设置返回数据编码为UTF-8）
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            in = conn.getInputStream();
            String fileName = generateFileName(scene, width);
            File outfile = new File(output + fileName);
            fos = new FileOutputStream(outfile);
            int len;
            byte[] buf = new byte[2048];
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            String rest = readFileByLines(output + fileName);
            Error error = null;
            try {
                error = gson.fromJson(rest, Error.class);
            } catch (Exception e) {
            }
            if (error != null) {
                throw new ACodeCreateException(fileName, error);
            }
            ;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static String generateFileName(String sence, int width) {
        return sence + "_" + width + ".jpeg";
    }

    /**
     * 信任任何站点，实现https页面的正常访问
     */

    private static void trustEveryone() {

        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    private static String readFileByLines(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                sb.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString();
    }


}
