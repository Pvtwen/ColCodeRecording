package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2021/11/2 14:21
 */
public class Messy {
    public static void messyIt(int[][] arr,int time){
        int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
        int zeroPositionX=2;
        int zeroPositionY=2;

        for(int i=1;i<=time;i++){
            int random = (int) (Math.random() * 4);
            int changeX = directions[random][0]+zeroPositionX;
            int changeY = directions[random][1]+zeroPositionY;
            if(condition(arr,changeX,changeY)){
                swap(arr,changeX,changeY ,zeroPositionX ,zeroPositionY);
                zeroPositionX=changeX;
                zeroPositionY=changeY;
            }
        }
    }
    public static boolean condition(int[][] arr,int i,int j){
        return i>=0 && i<3 && j>=0 && j<3;
    }
    public static void swap(int[][] arr,int i,int j,int i1,int j1){
        int temp=arr[i][j];
        arr[i][j]=arr[i1][j1];
        arr[i1][j1]=temp;
    }
}
