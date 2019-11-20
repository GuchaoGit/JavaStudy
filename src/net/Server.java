package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author guc
 * @Date 2019/11/20 15:38
 * @Description ServerSocket
 */
public class Server {
    public static final int PORT = 8088;
    private static Server mServer;
    private List<Socket> mClients;
    private ServerSocket mServerSocket;

    private Server() {
        Socket socket;
        mClients = new ArrayList<>();
        try {
            mServerSocket = new ServerSocket(PORT);
            mServerSocket.setSoTimeout(10 * 1000);//通过指定超时值启用/禁用 SO_TIMEOUT，以毫秒为单位。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Server getInstance() {
        if (mServer == null) {
            synchronized (Server.class) {
                if (mServer == null) {
                    mServer = new Server();
                }
            }
        }
        return mServer;
    }

    public void run() throws Exception {
        if (mServerSocket == null) throw new Exception("ServerSocket is null");
        while (true) {
            try {
                System.out.println("等待远程连接，端口号为：" + mServerSocket.getLocalPort() + "...");
                Socket server = mServerSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\n");
                server.close();
//                mClients.add(server);
            } catch (SocketTimeoutException e) {
                System.out.println("Socket time out! resume");
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
