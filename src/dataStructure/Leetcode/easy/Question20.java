package dataStructure.Leetcode.easy;

import java.util.Stack;

/**
 * @author 86153
 * @data 2021/7/30 22:32
 */
public class Question20 {
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] array = s.toCharArray();

        for (char c : array) {
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(c-pop!=1 && c-pop!=2){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
