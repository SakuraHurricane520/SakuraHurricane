
import java.io.File;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //记录开始时间
        // 输入txt文件
        String txt1 = String.valueOf((new File(args[0])));
        String txt2 = String.valueOf((new File(args[1])));

        // 如果都为空则输出提示信息并结束程序
        if(txt1.isEmpty() && txt2.isEmpty()){
            System.out.println("文件为空");
            System.exit(0);
        }

        Compute result=new Compute(txt1,txt2);

        // 输出结果到指定文件中
        Txt.output(result.sim(), args[0], args[1], args[2]);
        System.out.println("------------------------");
        System.out.println("结果文件路径：" + args[2]);


        long endTime = System.currentTimeMillis();    //记录结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

        System.exit(0);
    }
}
