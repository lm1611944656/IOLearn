package IOLearn;

/*
    后缀为Stream的都为字节流
    有Reader、Writer的都为字符流

    抽象基类
    InputStream
    OutputStream
    Reader
    Writer

    节点流(文件流)
    FileInputStream
    FileOutPutStream
    FileReader
    FileWriter
    缓冲流
    BufferedInputStream


 */

   /*
        将文件实例化，流引入，文件操作，利用try catch包住 将流关闭放在finally 再次利用try和catch包住
        不要再方法中抛出异常

        结论：
            文本文件(.txt .c .cpp .java)，利用字符流操作reader, writer
                可以指定一次读取的长度，也可以单独一个一个读.
                一个一个字符读test()
                指定一次读取的长度test2()
            非文本文件(.doc .jpg .mp3 .mp4), 利用字节流操作

     */

import org.junit.Test;

import java.io.*;

public class IOTest {
    // main 方法操作的文件是相对项目下的文件
    // 具体方法操作的是module下面的文件

    // 将Day1下面的文件读入到内存中，并且显示在控制台


    @Test
    public void test1() throws IOException {

        // 第一步，创建一个实例对象
        File file1 = new File("test.txt");

        // 具体流的引入
        FileReader fileReader = new FileReader(file1);

        // 数据的读入 (如果是数据的末尾直接返回一个 -1)
        int read = fileReader.read();
        while (read != -1) {
            System.out.print((char) read);
            read = fileReader.read();
        }
        /*
            代码简化
        int read;
        while(read = fileReader.read() != -1){
            System.out.print((char)read);
        }

         */


        // 数据的关闭
        fileReader.close();
    }

    @Test
    public void test2() {
        FileReader fileReader = null;

        try {
            // 文件的实例化
            File file = new File("test.txt");
            // 流的实例化
            fileReader = new FileReader(file);

            // 文件操作read(char[] cbuf)
            char[] chars = new char[1];

            int len;      // 记录每次读入到chars数组中的个数
            while ((len = fileReader.read(chars)) != -1) {   // 读到文件末尾，都是返回-1
                /*
                错误的写法
                for(int i = 0;i<chars.length;i++){
                    System.out.printf("%s",chars[i]);
                }
                 */
                for (int i = 0; i < len; i++) {
                    System.out.printf("%s", chars[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    // 文件关闭
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 文件的写操作
    @Test
    public void test3() {
        FileWriter fileWriter = null;
        try {
            // 创建要写文件的实例化
            File file = new File("writer_file.txt");

            // 提供流( 第二个参数是询问是否要覆盖原有内容  false表示要覆盖  true表示不覆盖，直接在末尾追加即可)
            // FileWriter(file,false)和FileWriter(file);是相同意思
            fileWriter = new FileWriter(file, false);

            // 文件操作
            fileWriter.write("Tencent Microsoft Amazon Google\n");
            fileWriter.write("Baidu Alibaba HUAWei\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    // 文件关闭
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    // 文件先读取，在写。即先读text.txt，在将其内容写入writer_file.txt中
    @Test
    public void test4() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //文件的实例化
            File file1 = new File("test.txt");
            File writer_file = new File("writer_file.txt");

            // 引入流操作
            fileReader = new FileReader(file1);  // 输入流
            fileWriter = new FileWriter(writer_file, true);    // 输出流

            //文件操作
            // 按照长度进行读写操作
            char[] chars = new char[5];
            int len;    // 记录每次读入到chars中的个数
            while ((len = fileReader.read(chars)) != -1) {
                // 读入多少个我们就写入多少个
                fileWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 文件的关闭
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
