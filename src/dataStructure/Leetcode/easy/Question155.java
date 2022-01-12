package dataStructure.Leetcode.easy;

        import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/22 16:21
 */
public class Question155 {
    //差值法
    Deque<Long> queue;
    long min;
    public Question155() {
        queue=new ArrayDeque<>();
    }

    public void push(int val) {
        if(queue.size()==0){
            min=val;
            queue.offer(0*1L);
        }else{
            long sub=val-min;
            if(sub>=0){
                queue.offer(sub);
            }else{
                queue.offer(sub);
                min=val;
            }
        }
    }

    public void pop() {
        long top = queue.getLast();
        if(top<0){
            long last = queue.getLast();
            queue.removeLast();
            min=min-last;
        }else{
            queue.removeLast();
        }
    }

    public int top() {
        long last = queue.getLast();
        if(last>=0) return (int) (min+last);
        else{
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
    // 优化辅助栈 思路二
//    Deque<Integer> queue;
//    Deque<Integer> helper;
//    public Question155() {
//        queue=new ArrayDeque<>();
//        helper=new ArrayDeque<>();
//    }
//
//    public void push(int val) {
//        queue.offer(val);
//        if(helper.size()!=0){
//            Integer last = helper.getLast();
//            if(val<=last) helper.offer(val);
//        }else{
//            helper.offer(val);
//        }
//    }
//
//    public void pop() {
//        Integer integer = queue.removeLast();
//        Integer last = helper.getLast();
//        if(integer.equals(last)) helper.removeLast();
//    }
//
//    public int top() {
//        return queue.getLast();
//    }
//
//    public int getMin() {
//        return helper.getLast();
//    }
    // 优化辅助栈 思路一
//    Deque<Integer> queue;
//    Deque<int[]> helper;
//    public Question155() {
//        queue=new ArrayDeque<>();
//        helper=new ArrayDeque<>();
//    }
//
//    public void push(int val) {
//        queue.offer(val);
//        if(helper.size()!=0){
//            int[] last = helper.getLast();
//            int i = last[0];
//            if(val>=i){
//                last[1]+=1;
//            }else {
//                helper.offer(new int[]{val,1});
//            }
//        }else{
//            helper.offer(new int[]{val,1});
//        }
//    }
//
//    public void pop() {
//        queue.removeLast();
//        int[] last = helper.getLast();
//        int count = last[1];
//        if(count>1){
//            last[1]-=1;
//        }else if(count==1){
//            helper.removeLast();
//        }
//    }
//
//    public int top() {
//        return queue.getLast();
//    }
//
//    public int getMin() {
//        int[] last = helper.getLast();
//        return last[0];
//    }
    //辅助栈
//    Deque<Integer> data;
//    Deque<Integer> helper;
//    public Question155() {
//        data=new ArrayDeque<>();
//        helper=new ArrayDeque<>();
//    }
//
//    public void push(int val) {
//        data.offer(val);
//        if(helper.size()!=0){
//            if(val> helper.getLast()){
//                Integer last = helper.getLast();
//                helper.add(last);
//            }else{
//                helper.offer(val);
//            }
//        }else{
//            helper.offer(val);
//        }
//    }
//
//    public void pop() {
//        data.removeLast();
//        helper.removeLast();
//    }
//
//    public int top() {
//        return data.getLast();
//    }
//
//    public int getMin() {
//        return helper.getLast();
//    }
//    List<Integer> list;
//    public Question155() {
//        list=new ArrayList<>();
//    }
//
//    public void push(int val) {
//        list.add(val);
//    }
//
//    public void pop() {
//        list.remove(list.size()-1);
//    }
//
//    public int top() {
//        return list.get(list.size()-1);
//    }
//
//    public int getMin() {
//        int min=Integer.MAX_VALUE;
//        for (Integer integer : list) {
//            if(integer<min) min=integer;
//        }
//        return min;
//    }
}
