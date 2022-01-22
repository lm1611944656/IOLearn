package BufferLearn;
/*
    buffer的作用：提高buffer的读写速度
 */

import java.io.*;

public class BufferTest {

    public void test1()  {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 文件的实例化
            File file1 = new File("D:\\Deep_Learn\\Workspace\\Data\\Predict_image\\image1.jpg");
            File file2 = new File("D:\\Deep_Learn\\Workspace\\Data\\Predict_image\\image3.jpg");


            // 创建输入输出流
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            // 创建缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            // 文件操作
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                // 流的关闭(只用关闭buffer流即可)
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
