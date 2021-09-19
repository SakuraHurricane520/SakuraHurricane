import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.io.File;
import java.util.List;

public class CutWord {      // CutWord类是使用word分词器进行分词
    public static List<Word> cutWord(File file){
    String string1 = Txt.input(file);   //调用文本
    List<Word> string2 = WordSegmenter.segWithStopWords(string1);  // 调用word分词器其中的分词函数
    return string2;
}
    public static List<Word> cutWord(String string1){
    List<Word> string2 = WordSegmenter.segWithStopWords(string1);
    return string2;
    }
}
