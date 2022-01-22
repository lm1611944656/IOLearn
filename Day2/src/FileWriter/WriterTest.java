package FileWriter;

import java.io.*;

public class WriterTest {
    // 文件的写入
    public void test1() {
        FileWriter fileWriter = null;
        try {
            File file = new File("D:\\Tools\\Java\\Java_workspace\\java_code\\IOLearn\\Day1\\test.txt");
            fileWriter = new FileWriter(file);

            // 文件操作
            fileWriter.write("cdhuihvfduifah");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null){
                try {
                    // 文件的关闭
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
