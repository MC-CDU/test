package cdu.mc.fileupload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lenovo
 */
public class FileServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("文件上传服务器开启成功！");
        //等待客户端连接
        while (true) {
            Socket client = serverSocket.accept();
            InputStream inputStream = client.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            //产生一个随机文件名
            FileOutputStream fileOutputStream = new FileOutputStream("f:\\img\\"+getName()+".jpg");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] buffer = new byte[1024];
            int len;
            while((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0,len);
            }
            System.out.println("接收成功！");
            bufferedOutputStream.close();
            fileOutputStream.close();
            bufferedInputStream.close();
            inputStream.close();
            serverSocket.close();
        }
    }

    public static String getName(){
        String[] str = {"a","b","c","d","e","f","g"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            stringBuilder.append(str[(int)(Math.random()*str.length)]);
        }
        return stringBuilder.toString();
    }
}
