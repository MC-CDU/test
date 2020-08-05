package cdu.mc.io;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author lenovo
 */
public class MyTest {

    /**
     * 字节流
     * 复制图片
     */
    @Test
    public void test01() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
             fileInputStream = new FileInputStream("f:\\file\\2.jpg");
             //如果目标文件夹下的文件不存在，就会创建该文件
             fileOutputStream = new FileOutputStream("f:\\file\\test\\马聪1.jpg");
            byte[] buffer = new byte[1024];
            int len;
            //read():会返回读取到的字节数，当读完了以后会返回-1
            while ((len = fileInputStream.read(buffer)) != -1) {
                System.out.println(len);
                fileOutputStream.write(buffer,0,len);
                //将缓冲区的数据全部放入IO流中
                fileOutputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test02() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("f:\\file\\test.txt");

            byte[] buffer = new byte[1024];
            //读取第一个byte数据
            int read;
            StringBuilder stringBuilder = new StringBuilder();
            while ((read = fileInputStream.read(buffer)) != -1){
                stringBuilder.append(new java.lang.String(buffer,0,read));
            }
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字节缓冲流
     */
    @Test
    public void test03() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("f:\\file\\test.txt"));
            byte[] buffer = new byte[1024];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer,0,len));
            }
            System.out.println(stringBuilder);
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("f:\\file\\test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流
     */
    @Test
    public void test04(){
        try {
            //字符流文件输入流
            FileReader fileReader = new FileReader("f:\\file\\test.txt");
            //缓冲字符输入流(装饰者模式)
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            TreeMap<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    //小于0就在二叉树的右边，就是升序
                    //大于0就在二叉树的左边，就是降序
                    return o1 - o2;
                }
            });
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                map.put((int) s.charAt(0),s);
            }
            Set<Map.Entry<Integer, String>> entries = map.entrySet();
            for (Map.Entry<Integer, String> entry : entries) {
                System.out.println(entry.getValue());
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05(){
        System.out.println(458%10);
    }

    /**
     * 转换流
     */
    @Test
    public void test06(){
        try {
            FileInputStream fileInputStream = new FileInputStream("f:\\file\\gbk.txt");
            //可以指定编码为GBK，如果该文件的编码不是GBK，这时就会出现乱码
            InputStreamReader gbk = new InputStreamReader(fileInputStream, "GBK");
            char[] buffer = new char[1024];
            int read = gbk.read(buffer);
            System.out.println(new String(buffer));
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test07() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("f:\\file\\utf-8.txt");
        //指定写入的文件的格式为utf-8
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
        outputStreamWriter.write("成都，10k+");
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    /**
     * 序列化和反序列化，就是方便对象在网络中传输
     */

    @Test
    public void test09() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("f:\\file\\test\\test.txt"));
        Student student = new Student("马聪", 15);
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }

    @Test
    public void test08() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("f:\\file\\test\\test.txt"));
        Object o = objectInputStream.readObject();
        Student student = (Student) o;
        System.out.println(student);
        objectInputStream.close();
    }

    /**
     * 加了transient关键字以后
     * @throws IOException
     */
    @Test
    public void test10() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("f:\\file\\test\\test.txt"));
        Student1 student = new Student1("韩叶茂", 38);
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }

    @Test
    public void test11() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("f:\\file\\test\\test.txt"));
        Object o = objectInputStream.readObject();
        Student1 student = (Student1) o;
        System.out.println(student);
        objectInputStream.close();
    }

}
