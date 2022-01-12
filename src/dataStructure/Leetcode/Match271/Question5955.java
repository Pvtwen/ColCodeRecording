package dataStructure.Leetcode.Match271;

/**
 * @author Yawen Cao
 * @data 2021/12/12 15:18
 */
public class Question5955 {
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int length = fruits.length;
        int[] prefixSumArr=new int[length+1];
        int sum=0;
        for(int i=1;i<=length;i++){
            sum+=fruits[i-1][1];
            prefixSumArr[i]=sum;
        }
        int ret=Integer.MIN_VALUE;
        // i: 刚开始先向左边走
        for(int i=0;i<=k;i++){
            int l = 0,r=0;
            if(i>=(int)(k/2+0.5)){
                l=startPos-k;
                r=startPos;
            }else{
                l=startPos-i;
                r=startPos+k-2*i;
            }
            int j=0;
            int w = length - 1;
            // 二分查找第一个大于等于l的位置
            while(j<=w){
                int mid=(j+w)/2;
                if(j==w) break;
                else if(fruits[mid][0]>=l) w=mid;
                else if(fruits[mid][0]<l) j=mid+1;
            }
            // 如果没找到
            if(fruits[j][0]<l) continue;
            // 左边的有水果的位置
            int left=j;
            j = 0;w=length-1;
            // 二分查找第一个小于等于r的位置
            while(j<=w){
                int mid=(j+w)/2;
                if(j==w || j==w-1) break;
                else if(fruits[mid][0]<=r) j=mid;
                else if(fruits[mid][0]>r) w=mid-1;
            }
            // 右边的有水果的位置
            int right;
            // 如果没找到
            if(fruits[j][0]>r) continue;
            if(fruits[w][0]<=r) right=w;
            else right=j;
            System.out.println("先向左走"+i+"步,然后向右走,对应的左边界的下标为"+left+"对应的有边界的下标为"+right);
            // 前缀和求水果总量
            ret=Math.max(ret,prefixSumArr[right+1]-prefixSumArr[left]);
        }
        System.out.println();
        // i: 刚开始先向右边走
        for(int i=0;i<=k;i++){
            int l = 0,r=0;
            if(i>=(int)(k/2+0.5)){
                l=startPos;
                r=startPos+k;
            }else{
                l=startPos-(k-2*i);
                r=startPos+i;
            }
            int j=0;
            int w = length - 1;
            // 二分查找第一个大于等于l的位置
            while(j<=w){
                int mid=(j+w)/2;
                if(j==w) break;
                else if(fruits[mid][0]>=l) w=mid;
                else if(fruits[mid][0]<l) j=mid+1;
            }
            // 如果没找到
            if(fruits[j][0]<l) continue;
            // 左边的有水果的位置
            int left=j;
            j = 0;w=length-1;
            // 二分查找第一个小于等于r的位置
            while(j<=w){
                int mid=(j+w)/2;
                if(j==w || j==w-1) break;
                else if(fruits[mid][0]<=r) j=mid;
                else if(fruits[mid][0]>r) w=mid-1;
            }
            // 右边的有水果的位置
            int right;
            // 如果没找到
            if(fruits[j][0]>r) continue;
            if(fruits[w][0]<=r) right=w;
            else right=j;
            System.out.println("先向右走"+i+"步,然后向右走,对应的左边界的下标为"+left+"对应的有边界的下标为"+right);
            // 前缀和求水果总量
            ret=Math.max(ret,prefixSumArr[right+1]-prefixSumArr[left]);
        }
        return ret;
    }
}
