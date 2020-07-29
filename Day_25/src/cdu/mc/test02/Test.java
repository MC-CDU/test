package cdu.mc.test02;

import java.io.*;

/**
 * @author lenovo
 */
public class Test {

    public static void main(String[] args) throws IOException {
        /**
         * 2）完成文件D://a.txt复制到E://a.txt（3分）
         */
        File file = new File("d:\\a.txt");
        File file1 = new File("e:\\a.txt");
        if (file1.exists()) {
            file1.createNewFile();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            byte[] buffer = new byte[(int) file.length()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
