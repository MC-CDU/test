package cdu.mc.file;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lenovo
 */
public class FileTest {

    @Test
    public void test01(){

        File file = new File("f:\\file\\test");
        if (!file.exists()) {
            //创建文件夹
            file.mkdir();
        }
        File file1 = new File(file, "test.txt");
        try {
            //创建文件
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02(){
        File file = new File("f:\\file\\test\\test.txt");
        byte[] buffer = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            buffer = new byte[]{78, 85,89,45,45,56,78,89};
            fileOutputStream.write(buffer);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        File file = new File("f:\\file");
        test04(file);
    }

    public void test04(File file){
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                System.out.println(file1.getName());
                test04(file1);
            }
        }
    }

    /**
     * 一块钱一瓶水，三个空瓶或者两个瓶盖可以换一瓶水，问17块钱最多可以喝多少瓶水？
     */
    @Test
    public void test05() {
        int i = test06(17);
        System.out.println(i);
    }

    public int test06(int count) {
        if (count >= 2) {
            int i = count / 3;
            int i2 = 0;
            if (count == 2) {
                i2 = 0;
            }else {
                i2 = count % 3;
            }
            int i1 = count / 2;
            int i3 = count % 2;
            return count + test06(i + i1 + i2 + i3);
        }else {
            return 1;
        }
    }

    @Test
    public void test07(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("555");
            }
        });
        thread.run();
        System.out.println("666");
    }

    @Test
    public void test08() {
       char c = '中';
        System.out.println((int)c);
    }

    @Test
    public void test09() {
        System.out.println(Math.round(1.5));
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        System.out.println(nums[1]);
    }

}
