package dataStructure.Leetcode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/11/27 9:49
 */
public class Question146 {
    DLinkedNode head;
    DLinkedNode tail;
    HashMap<Integer,DLinkedNode> map=new HashMap<>();
    int size;
    int capacity;
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public void addToHead(DLinkedNode node){
        DLinkedNode next = head.next;
        node.next=next;
        next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    public void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next=next;
        next.prev=prev;
    }
    public DLinkedNode removeTail(){
        DLinkedNode prev1 = tail.prev;
        DLinkedNode prev = tail.prev.prev;
        prev.next=tail;
        tail.prev=prev;
        return prev1;
    }

    public Question146(int capacity) {
        this.capacity=capacity;
        size=0;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DLinkedNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            DLinkedNode node=new DLinkedNode(key,value);
            map.put(key,node);
            addToHead(node);
            size++;
            if(size>capacity){
                DLinkedNode tail=removeTail();
                map.remove(tail.key);
                size--;
            }
        }else{
            DLinkedNode node = map.get(key);
            node.value=value;
            moveToHead(node);
        }
    }
//    HashMap<Integer,Integer> map;
//    int[] arr;        // key  time
//    int cap;
//    public Question146(int capacity) {
//        cap=capacity;
//        map=new HashMap<>();
//        arr=new int[100010];
//    }
//
//    public int get(int key) {
//        if(!map.containsKey(key)) return -1;
//        arr[key]=-1;
//        for (Integer k : map.keySet()) {
//            arr[k]+=1;
//        }
//        return map.get(key);
//    }
//
//    public void put(int key, int value) {
//        int size = map.size();
//
//        if(size==cap){
//            if(!map.containsKey(key)){
//                map.put(key,value);
//                arr[key]=-1;
//                int maxTime=-1;int Idx=-1;
//                for (Integer k : map.keySet()) {
//                    arr[k]+=1;
//                    if(arr[k]>maxTime){
//                        maxTime=arr[k];
//                        Idx=k;
//                    }
//                }
//                map.remove(Idx);
//            }else{
//                map.put(key,value);
//                arr[key]=-1;
//                for (Integer k : map.keySet()) {
//                    arr[k]+=1;
//                }
//            }
//        }else if(size<cap){
//            map.put(key,value);
//            arr[key]=-1;
//            for (Integer k : map.keySet()) {
//                arr[k]+=1;
//            }
//        }
//    }
}
