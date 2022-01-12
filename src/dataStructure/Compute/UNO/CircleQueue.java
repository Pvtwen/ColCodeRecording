package dataStructure.Compute.UNO;

import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/28 15:04
 */
public class CircleQueue {
    Player head;
    Player tail;
    public CircleQueue(){
        head.next=tail;
        tail.pre=head;
        tail.next=head;
        head.pre=tail;
    }
    public void addAElement(Player ele){
        Player pre = tail.pre;
        ele.next=tail;

        pre.next=ele;
        ele.pre=pre;
        tail.pre=ele;
    }

}
