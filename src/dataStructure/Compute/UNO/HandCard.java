package dataStructure.Compute.UNO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/23 14:48
 */
public class HandCard {
    HashMap<String,Integer> map;
    int handCardNum;
    public HandCard() {
        map=new HashMap<>();
        init();
        handCardNum=7;
    }
    public void init(){
        for(int i=0;i<7;i++){
            grapOneCard();
        }
    }
    // card 上一家打的牌
    public Card controller(Card card){
        Scanner sc = new Scanner(System.in);
        String num = card.num;
        // +2
        if(num.equals("10")){
            grapOneCard();
            grapOneCard();
            handCardNum+=2;
            return null;
        }
        this.diplayCard();
        // 判断有无牌可出
        boolean b = checkCard(card);
        if(!b){
            System.out.println("你无牌可出 摸一张牌");
            Card card1 = grapOneCard();
            System.out.println("卡牌信息"+card1.combine());
            boolean b1 = checkCard(card1);
            if(!b1){
                // 无牌可出 返回上一家的牌
                handCardNum++;
                return card;
            }else{
                System.out.println("your choices is: 1.pass . 2.play this card");
                int i = sc.nextInt();
                if(i==1) {
                    handCardNum++;
                    return card;
                }
                else if(i==2){
                    return card1;
                }
            }
        }else{
            diplayCard();
            System.out.println("your choices is: 1.grab one card . 2.play a card");
            int choice = sc.nextInt();
            if(choice==2){
                // play a card function
                String choosedCard = sc.next();

                map.put(choosedCard,map.get(choosedCard)-1);
                if(map.get(choosedCard)==0) map.remove(choosedCard);
//                choosedCard.substring()
                String color = choosedCard.substring(0, 1);
                String cNum = choosedCard.substring(1, choosedCard.length());
                Card pCard=new Card(cNum,color);
                handCardNum--;
                return pCard;
            }else{  // 摸一张牌
                Card card1 = grapOneCard();
                System.out.println("卡牌信息"+card1.combine());
                boolean b1 = checkCard(card1);
                if(!b1){
                    handCardNum++;
                    return card;
                }else{
                    System.out.println("your choices is: 1.pass . 2.play this card");
                    int i = sc.nextInt();
                    if(i==1) {
                        handCardNum++;
                        return card;
                    }
                    else if(i==2){
                        return card1;
                    }
                }
            }
        }
        return card;
    }
    public boolean checkCard(Card card){
        String color = card.color;
        boolean b = checkColor(color);
        return b;
    }
    public boolean checkColor(String color){
        Set<String> keySet = map.keySet();
        for (String c : keySet) {
            if(c.startsWith(color)) return true;
        }
        return false;
    }
    public void diplayCard(){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("你的手牌");
        for (Map.Entry<String, Integer> entry : entries) {
            String card = entry.getKey();
            Integer count = entry.getValue();
            System.out.print(card+":"+count);
        }
    }
    public Card grapOneCard(){
        Card card=new Card();
        String color = card.color;
        String num = card.num;
        String combine=color+""+num;
        map.put(combine,map.getOrDefault(combine,0)+1);
        return card;
    }
    public int getCardValue(){
        int sum=0;
        for (Map.Entry<String, Integer> entries : map.entrySet()) {
            String cardInfo = entries.getKey();
            Integer num = entries.getValue();
            int value = statisticCardValue(cardInfo,num);
            sum+=value;
        }
        return sum;
    }
    public int statisticCardValue(String cardInfo,int num){
        String number = cardInfo.substring(1, cardInfo.length());
        if(number.length()==1){
            int i = Integer.parseInt(number);
            return i*num;
        }else{
            if(number.equals("+2") || number.equals("rev") || number.equals("pass")) return 20*num;
            else return 40*num;
        }
    }
}
