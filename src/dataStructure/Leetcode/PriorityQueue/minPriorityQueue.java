package dataStructure.Leetcode.PriorityQueue;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/10/16 12:25
 */
public class minPriorityQueue {
    int[] arr;
    int length;

    public minPriorityQueue(int[] arr){
        this.arr=arr;
        length=arr.length;

        for(int i=length/2-1;i>=0;i--){
            heapify(arr,i,length);
        }
    }

    public int pop(){
        int temp=arr[0];
        swap(arr,0,length-1);
        length--;
        return temp;
    }

    public void add(int num){
        arr = Arrays.copyOf(arr, length + 1);
        length++;
        int i=length-1;
        arr[i]=num;

        int parent;
        if(i%2==0) parent=i/2-1;
        else parent=i/2;

        while(parent>=0 && num<arr[parent]){
            arr[i]=arr[parent];
            i=parent;
            if(i%2==0) parent=i/2-1;
            else parent=i/2;
        }
        arr[i]=num;
    }

    public void heapify(int[] arr,int i,int length){
        int temp=arr[i];
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length && arr[k]>arr[k+1]) k++;
            if(arr[k]<temp){
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
