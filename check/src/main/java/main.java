
import org.apdplat.word.segmentation.Word;
import java.io.File;
import java.util.List;



public class main {
    public static void main(String[] args) {
        // 输入txt文件
        String txt1 = String.valueOf((new File(args[0])));
        String txt2 = String.valueOf((new File(args[1])));

        // 如果都为空则输出提示信息并结束程序
        if(txt1.isEmpty() && txt2.isEmpty()){
            System.out.println("文件为空");
            System.exit(0);
        }

        // 调用Compute类进行相似度计算
        //double result = Compute.similarityCalculate(txt1, txt2);
        //double result = Compute.getSimilarity(txt1,txt2);

        Compute result=new Compute(txt1,txt2);

        // 输出结果到指定文件中
        Txt.output(result.sim(), args[0], args[1], args[2]);
        System.out.println("------------------------");
        System.out.println("结果文件路径：" + args[2]);
        System.exit(0);
    }
}
