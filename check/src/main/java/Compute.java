


import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


import org.apdplat.word.segmentation.Word;

import java.math.BigDecimal;
import java.util.*;

public class Compute {

    Map<Character, int[]> vectorMap = new HashMap<Character, int[]>();
    int[] tempArray = null;

    public Compute(String source, String target) {
        for (Character sch : source.toCharArray()) {
            if (vectorMap.containsKey(sch)) {
                vectorMap.get(sch)[0]++;
            }
            //用将字符转化为向量
            else {
                tempArray = new int[2];
                tempArray[0] = 1;
                tempArray[1] = 0;
                vectorMap.put(sch, tempArray);
            }
        }
        for (Character tch : target.toCharArray()) {

            if (vectorMap.containsKey(tch)) {
                vectorMap.get(tch)[1]++;
            }
            //用将字符转化为向量
            else {
                tempArray = new int[2];
                tempArray[0] = 0;
                tempArray[1] = 1;
                vectorMap.put(tch, tempArray);
            }
        }
    }



    // 求余弦相似度
    public double sim() {
        double result = 0;
        result = pointMulti(vectorMap) / sqrtMulti(vectorMap);
        return result;
    }


    // 求平方和
    private double squares(Map<Character, int[]> paramMap) {
        double result1 = 0;
        double result2 = 0;
        Set<Character> keySet = paramMap.keySet();
        for (Character character : keySet) {
            int temp[] = paramMap.get(character);
            result1 += (temp[0] * temp[0]);
            result2 += (temp[1] * temp[1]);
        }
        return result1 * result2;
    }

    // 点乘法
    private double pointMulti(Map<Character, int[]> paramMap) {
        double result = 0;
        Set<Character> keySet = paramMap.keySet();
        for (Character character : keySet) {
            int[] temp = paramMap.get(character);
            result += (temp[0] * temp[1]);
        }
        return result;
    }

    private double sqrtMulti(Map<Character, int[]> paramMap) {
        double result = 0;
        result = squares(paramMap);
        result = Math.sqrt(result);
        return result;
    }

}
