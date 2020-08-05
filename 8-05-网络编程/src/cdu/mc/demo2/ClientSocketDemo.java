package cdu.mc.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lenovo
 */
public class ClientSocketDemo {
    public static void main(String[] args) throws IOException {
        //注意：在一个套接字程序中，如果通过socket获得的流对象被关闭了，那么整个套接字也就被关闭了
        Socket socket = new Socket("127.0.0.1", 6666);
        System.out.println("客户端启动成功！");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务器你好，我是客户端!".getBytes());
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int read = inputStream.read(buffer);
        System.out.println("收到了服务器的消息：" + new String(buffer,0,read));
        System.out.println(socket.isClosed());
        outputStream.close();
        System.out.println(socket.isClosed());
        inputStream.close();
        socket.close();
    }
}
