package OtherIO;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIN {
    public static void main(String[] args){
        SystemIN systemIN = new SystemIN();
        systemIN.test1();
    }
    // 从键盘直接输出字符

    public void test1(){
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            // 文件操作
            while(true){
                System.out.print("请输入字符串：");
                String readLine = bufferedReader.readLine();
                /*
                // 方式一(会出现空指针问题)
                if((readLine.equalsIgnoreCase("e"))||(readLine.equalsIgnoreCase("exit"))){
                    System.out.println("程序结束！");
                    break;
                }
                 */
                // 选着方式二(避免空指针问题)
                if(("e".equalsIgnoreCase(readLine))||("exit".equalsIgnoreCase(readLine))){
                    System.out.println("程序结束！");
                    break;
                }
                // 如果输入的不是"e","exit"   就将字符转换为大写
                String toUpperCase = readLine.toUpperCase();
                System.out.println(toUpperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    // 缓冲流的关闭
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
