package StreamTest;

import org.junit.Test;

import java.io.*;

public class StreamTest {
    // 操作非文本文件(将图片进行复制)
    @Test
    public void test1() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 文件的实例化
            File sourceFile = new File("D:\\Deep_Learn\\Workspace\\Data\\Predict_image\\image1.jpg");
            File copyFile = new File("D:\\Deep_Learn\\Workspace\\Data\\Predict_image\\image2.jpg");

            // 引入流
            fileInputStream = new FileInputStream(sourceFile);
            fileOutputStream = new FileOutputStream(copyFile);

            // 文件操作
            byte[] bytes = new byte[5];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes,0,len);
            }
            System.out.println("图片复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                // 流的关闭
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
