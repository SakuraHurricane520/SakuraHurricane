import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


public class Txt {    //Txt类是有关文件的读取写入
    public static String input(File file){
        StringBuilder result = new StringBuilder();  // 转换成string类型，存放结果
        try{
            BufferedReader read = new BufferedReader(new FileReader(file)); // 读取文件
            String a = null;
            while ((a = read.readLine())!= null){
                result.append(System.lineSeparator()).append(a);
            }
            read.close();
        }
        catch (Exception e){   //抛出异常
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void output(double result, String orig1, String orig2, String jueduilujing){
        try{                             // 将结果输出到p所指定的位置
            FileWriter write = new FileWriter(jueduilujing);
            PrintWriter out = new PrintWriter(write, false);

            // DecimalFormat df = new DecimalFormat("##.##");
            // String rate = df.format(result*100).toString();

            result *= 100;
            String output = String.format("%.2f", result);
            out.print("原文：" + orig1 + "\n");
            out.print("须查重文件：" + orig2 + "\n");
            out.print("查重结果为：" + output + "%");
            write.close();
            out.close();
        }
        catch (IOException e){     //抛出异常
            e.printStackTrace();
        }
    }
}
