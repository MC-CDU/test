package cdu.mc.fileupload;

import java.io.*;
import java.net.Socket;

/**
 * @author lenovo
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("10.7.161.77", 6666);
        System.out.println("客户端创建成功！");
        OutputStream outputStream = client.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        //创建流去读取要上传的文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("f:\\file\\2.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer,0,len);
        }
        System.out.println("图片上传成功！");
        bufferedInputStream.close();
        bufferedOutputStream.close();
        outputStream.close();
        client.close();
    }

}
