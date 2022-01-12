package dataStructure.Compute.UNO;

/**
 * @author Yawen Cao
 * @data 2021/11/23 14:46
 */
public class Card {
    public String num; // 1~10
    public String color;
    //1 r 2 y 3 g
    public Card(){
        generateColorAndNum();
    }
    public Card(int i){
        generateInitCard();
    }
    public Card(String num,String color){
        this.num=num;
        this.color=color;
    }
    public void generateInitCard(){
        int number = (int) (Math.random() * 9 + 1);
    }
    public void generateColorAndNum(){
        // 1~9 number
        int number = (int) (Math.random() * 10 + 1);
        if (number==10) num="+2";
        else num=""+number+"";
        // 1~3 color
        int col=(int) (Math.random()*3+1);
        if(col==1) color="红";
        if(col==2) color="黄";
        if(col==3) color="绿";
    }
    public String combine(){
        return num+""+color;
    }
}
