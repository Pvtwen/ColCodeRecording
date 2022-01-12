package DataMining.Mission3;

/**
 * @author Yawen Cao
 * @data 2021/10/18 20:35
 */
public class Shuffle {
    public int[] shuffleIt(int[] arr){
        int max;
        int temp;
        for(int i=arr.length-1;i>=0;i--){
            max=i;
            // 生成的随机数的范围是 0,max
            int randomIndex= (int) (Math.random()*(max+1));
            temp=arr[randomIndex];
            arr[randomIndex]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }
}
