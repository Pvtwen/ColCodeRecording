package dataStructure.Leetcode.Match258;

/**
 * @author Yawen Cao
 * @data 2021/9/12 10:32
 */
public class Question5867 {
    public String reversePrefix(String word, char ch) {
        if(word.indexOf(ch)==-1) return word;
        StringBuilder stringBuilder=new StringBuilder();
        int index=word.indexOf(ch);
        return stringBuilder.append(word, 0, index+1).reverse().append(word.substring(index+1)).toString();
    }
}
