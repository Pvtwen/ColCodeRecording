package dataStructure.Compute;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Queue;

/**
 * @author Yawen Cao
 * @data 2021/10/21 19:54
 */
public class Compute {
    Deque<Character> queue;
    public Compute(){
        queue=new ArrayDeque<>();
    }

    public int compute(){
        Scanner scanner=new Scanner(System.in);
        String s = scanner.next();
        int index=0;
        int length=s.length();

        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            queue.offer(c);
        }

        Deque<Integer> integerDeque=new ArrayDeque<>();
        Deque<Character> characterDeque=new ArrayDeque<>();
        while(!queue.isEmpty()){
            String string="";
            Character c = queue.getFirst();
            if(c>=48 && c<=57){
                while(c>=48 && c<=57 && !queue.isEmpty()){
                    string+=c;
                    queue.poll();
                    if(!queue.isEmpty())
                        c = queue.getFirst();
                }
                integerDeque.offer(Integer.parseInt(string));
            }else{
                characterDeque.offer(c);
                queue.poll();
            }
        }
        while(!integerDeque.isEmpty() && !characterDeque.isEmpty()){
            Integer integer1 = integerDeque.removeLast();
            Integer integer = integerDeque.removeLast();
            Character character = characterDeque.removeLast();
            int compute = compute(integer, integer1, character);
            integerDeque.offer(compute);
        }
        return integerDeque.poll();
    }
    public int compute(int x,int y,Character option){
        if(option.equals('+')) return x+y;
        if(option.equals('-')) return x-y;
        if(option.equals('*')) return x*y;
        if (option.equals('/')) return x/y;
        return -1;
    }
}
