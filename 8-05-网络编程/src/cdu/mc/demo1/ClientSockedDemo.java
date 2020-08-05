package cdu.mc.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lenovo
 */
public class ClientSockedDemo {
    public static void main(String[] args) throws IOException {
        //模拟客户端
        //需要指定服务器端的ip和端口
        Socket socket = new Socket("10.7.161.77", 6666);
        System.out.println("客户端创建成功！");
        //获取输入流，用来发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你马上就要死了".getBytes());
        outputStream.close();
        socket.close();
    }
}
