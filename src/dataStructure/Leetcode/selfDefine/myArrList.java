package dataStructure.Leetcode.selfDefine;

/**
 * @author Yawen Cao
 * @data 2021/11/28 16:31
 */
public class myArrList<T> {
    T[] arr;
    int cur=0;
    public myArrList(){
        arr= (T[]) new Object[5];
    }
    public void add(T e){
        arr[cur]=e;
        cur++;
    }
    public T get(int idx){
        return arr[idx];
    }
}
