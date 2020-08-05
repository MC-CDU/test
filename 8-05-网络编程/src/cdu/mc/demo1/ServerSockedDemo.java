package cdu.mc.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author lenovo
 */
public class ServerSockedDemo {
    public static void main(String[] args) throws IOException {
        //模拟服务器端
        //ip默认为本机，所以只需要设置端口即可
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务器开启成功！等待客户端的连接！");
        //程序阻塞，等待客户端！
        Socket client = serverSocket.accept();
        //获取客户端的IP地址
        String ip = client.getInetAddress().getHostName();
        //获取客户端的端口
        int port = client.getPort();
        System.out.println("收到了ip为:"+ ip + ",端口为:" + port + "发来的消息：");
        InputStream inputStream = client.getInputStream();
        byte[] buffer = new byte[1024];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer,0,read));
        inputStream.close();
        serverSocket.close();
    }
}
