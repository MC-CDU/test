package cdu.mc.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lenovo
 */
public class ServerSockedDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动成功！");
        Socket client = serverSocket.accept();
        InputStream inputStream = client.getInputStream();
        byte[] buffer = new byte[1024];
        int read = inputStream.read(buffer);
        System.out.println("你好" + client.getInetAddress().getHostName());
        System.out.println("我收到了你的消息：" + new String(buffer,0,read));
        OutputStream outputStream = client.getOutputStream();
        outputStream.write("你好客户端，我是服务器".getBytes());
        outputStream.close();
        inputStream.close();
        client.close();
        serverSocket.close();
    }
}
