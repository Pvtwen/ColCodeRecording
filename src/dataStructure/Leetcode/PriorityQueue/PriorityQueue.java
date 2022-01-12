package dataStructure.Leetcode.PriorityQueue;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/10/16 11:33
 */
public class PriorityQueue {
    //大根堆
    int[] arr;
    int length;
    public PriorityQueue(int[] arr){
        this.arr=arr;
        length=arr.length;

        for(int i=length/2-1;i>=0;i--){
            heapify(arr,i,length);
        }
//        for(int i=length-1;i>0;i--){
//            swap(arr,0,i);
//            heapify(arr,0,i);
//        }
    }

    // 最大值出队列
    public void pop(){
        swap(arr,0,length-1);
        length--;
        heapify(arr,0,length);
    }

    // 入队列
    public void add(int num){
        arr = Arrays.copyOf(arr, length + 1);
        length++;

        int i=length-1;
        int parent;
        arr[i]=num;
        if(i%2==0) parent=i/2-1;
        else parent=i/2;
        while(parent>=0 && arr[i]>arr[parent]){
            swap(arr,i,parent);
            i=parent;
            if(i%2==0) parent=i/2-1;
            else parent=i/2;
        }
    }

    public void heapify(int[] arr,int i,int length){
        int temp=arr[i];
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length && arr[k]<arr[k+1]) k++;
            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else break;
        }
        arr[i]=temp;
    }

    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public void printf(){
        for(int i=0;i<length;i++){
            System.out.println(arr[i]);
        }
    }
}
