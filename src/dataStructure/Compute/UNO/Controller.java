package dataStructure.Compute.UNO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yawen Cao
 * @data 2021/11/28 10:01
 */
public class Controller {
    static Player[] arr=new Player[4];
    public static void main(String[] args) {
        int position=1; //顺序
        Player p1=new Player();
        Player p2=new Player();
        Player p3=new Player();
        Player p4=new Player();
        p1.next=p2;p2.next=p3;p3.next=p4;p4.next=p1;
        p1.pre=p4;p2.pre=p1;p3.pre=p2;p4.pre=p3;
        int cur=0;Player curPlayer=p1;
        Card preCard=new Card(1);
        int countTime=0;
        while(curPlayer.handCard.handCardNum!=0 && countTime<300){
            countTime++;
            preCard = curPlayer.handCard.controller(preCard);
            if(curPlayer.handCard.handCardNum==0) break;
            String num = preCard.num;
            if(num.equals("rev")){
                position=-position;
            }
//            if(num.equals("pass")){
//                if(position==1){
//                    cur=(cur+2)%4;
//                }else{
//                    cur-=2;
//                    if(cur==-1) cur=4;
//                    if(cur==-2) cur=3;
//                }
//            }
            if(num.equals("pass")){
                if(position==1){
                    curPlayer=curPlayer.next.next;
                }else{
                    curPlayer=curPlayer.pre.pre;
                }
                continue;
            }
            if(position==1){
                curPlayer=curPlayer.next;
            }else{
                curPlayer=curPlayer.pre;
            }
        }
        if(curPlayer.handCard.handCardNum==0) System.out.println("赢的人是"+cur);
        else if(countTime==300){
            int v1 = p1.handCard.getCardValue();
            int v2 = p2.handCard.getCardValue();
            int v3 = p3.handCard.getCardValue();
            int v4 = p4.handCard.getCardValue();
            int max = Math.max(Math.max(v1, v2), Math.max(v3, v4));
            if(max==v1) System.out.println("输的人"+1);
            if(max==v2) System.out.println("输的人"+2);
            if(max==v3) System.out.println("输的人"+3);
            if(max==v4) System.out.println("输的人"+4);
        }
    }
}