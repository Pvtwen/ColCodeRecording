package DataMining;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/9/8 18:26
 */
public class ExperimentOne {
    static int[] arrA;
    public static void main(String[] args) {
        QuestionOne();
        shuffle(arrA);
        int[] sample1 = randomSampling2(arrA, 10000);
        distribution(sample1);
        int[] sample2 = randomSampling2(arrA, 100000);
        distribution(sample2);
        int[] sample3 = randomSampling2(arrA, 1000000);
        distribution(sample3);
    }

    public static void QuestionOne(){
        arrA=new int[(int) Math.pow(10,7)];
        Arrays.fill(arrA,0, (int) (Math.pow(10,7)/2),0);
        Arrays.fill(arrA, (int) (Math.pow(10,7)/2), (int) Math.pow(10,7),1);
    }

    //时间复杂度 O(n)
    // 算法参考网址 https://gaohaoyang.github.io/2016/10/16/shuffle-algorithm/
    public static void shuffle(int[] arr){
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
    }

    //时间复杂度 O(n^2)
    public static int[] randomSampling2(int[] arr,int n){
        int[] sample=new int[n];
//         设置状态变量  用来判断哪些样本是采取过的
        boolean[] visited=new boolean[arr.length];
        int max=arr.length-1;
        int min=0;
        int random;
        for(int i=1;i<=n;i++){
            random= (int) (Math.random()*(max-min+1));
            // 如果生成的随机下标已经被访问过  再次生成
            while(visited[random]){
                random=(int)(Math.random()*(max-min+1));
            }
            sample[i-1]=arr[random];
            visited[random]=true;
        }
        return sample;
    }

    // n为采取样本量
    // 时间复杂度O(n)
    public static int[] randomSampling(int[] arr,int n){
        int[] sample=new int[n];
        int temp;
        //时间复杂度O(n)  思路参照shuffle算法
        // 每生成一个随即下标  将对应下标的元素与数组中的最后一个元素交换  避免再次被抽取
        for(int i=arr.length-1,j=0;i>=arr.length-n;i--,j++){
            int randomIndex= (int) (Math.random()*(i+1));
            sample[j]=arr[randomIndex];

            temp=arr[randomIndex];
            arr[randomIndex]=arr[i];
            arr[i]=temp;
        }
        return sample;
    }

    public static void distribution(int[] arr){
        // 记录1和0的个数
        int count1=0,count0=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1) count1++;
            else count0++;
        }
        System.out.println("1:0="+count1+":"+count0);
    }
}