package dataStructure.Compute.UNO;

/**
 * @author Yawen Cao
 * @data 2021/11/28 9:54
 */
public class Player {
    public HandCard handCard;
    public Player pre;
    public Player next;
    public Player(){
        handCard=new HandCard();
    }
}
