package DataMining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Yawen Cao
 * @data 2021/9/10 20:01
 */
public class Test {

    static Random random = new Random();
    public static void main(String[] args) {
        //步骤1 构建数组A
        Integer[] A = new Integer[10000000];
        Arrays.fill(A,0,A.length/2,0);
        Arrays.fill(A,A.length/2,A.length,1);

        //步骤2 洗牌
        Integer[] a = myShuffle(A).toArray(new Integer[0]);

        int[] nums = new int[]{3,5,7};
        for(int num:nums){
            //步骤3 取样
            Integer[] b =sampling(a,num);
            System.out.println(Arrays.toString(b));
            int sum=0;
            float result=0;
            for (int i=0;i<num;i++){
                sum+=b[i];
            }
            result = sum/(float)num;
            System.out.println("数量为"+num+"时，1的分布:"+result+",0的分布:"+(1-result));
        }
    }

    //步骤2 洗牌
    public static List<Integer> myShuffle(Integer[] A){
        List<Integer> B = Arrays.asList(A);
        List b = new ArrayList(B);
        List<Integer> result = new ArrayList<>();
        while (b.size()>0){
            Integer index = random.nextInt(b.size());
            result.add((Integer) b.get(index));
            b.remove(b.get(index));
        }
        return result;
    }

    //步骤3 取样
    public static Integer[] sampling(Integer[] a,int n){
        Integer[] result = new Integer[n];
        int l = a.length;
        boolean[] booleans = new boolean[l];
        int i=0;
        while (i<n){
            int index=random.nextInt(l);
            if(!booleans[index]){
                result[i] = a[index];
                booleans[index] = true;
                i++;
            }
        }
        return result;
    }
}