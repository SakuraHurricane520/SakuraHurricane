import java.io.*;

public class Txt {    //Txt类是有关文件的读取写入

    public static void output(double result, String orig1, String orig2, String absolute){
        try{                             // 将结果输出到所指定的位置a
            FileWriter write = new FileWriter(absolute);
            PrintWriter out = new PrintWriter(write, false);
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
