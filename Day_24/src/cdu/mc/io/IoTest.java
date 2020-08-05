package cdu.mc.io;

import org.junit.Test;

import java.io.*;

/**
 * @author lenovo
 */
public class IoTest {

    @Test
    public void test01() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("f:\\test.txt"));
            String str = "你好啊，傻逼！";
            byte[] buffer = str.getBytes();
            fileOutputStream.write(buffer);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        try {
            //设置true表示在不覆盖以前文件的基础上继续写，默认是false
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("f:\\test.txt",true));
            String str = "成都腾讯大厦";
            bufferedWriter.write("\n" + str);
            //清空缓冲区数据
            bufferedWriter.flush();
            //关闭字符输出流
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
        stringBuffer.append(2);
        stringBuffer.append(3);
        System.out.println(stringBuffer);

        //stringBuffer.deleteCharAt(1);

        stringBuffer.insert(0, 'c');
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer);
    }

}
