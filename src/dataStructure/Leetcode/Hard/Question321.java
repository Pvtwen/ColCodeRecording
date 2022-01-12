package dataStructure.Leetcode.Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/10/5 10:08
 * 1. k-deque1.size-deque2.size<remainNum才能继续循环
 * 2. 当deque1和deque2都需要removeLast时，nums1[i]>nums2[j],则nums1 removeLast，保证大的数尽量靠前
 * 如果nums1[i]==num2[i],deque1.getLast<deque2.getLast,则deque1.removeLast 道理与上述相同
 * 3. 遍历完，如果deque1.size+deque2.size>>k,截取前k个数字
 * 4. 不能提前终止遍历
 */
public class Question321 {
//    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int n = nums1.length;
//        int m = nums2.length;
//
//        Deque<Integer> deque1 = new ArrayDeque<>();
//        Deque<Integer> deque2 = new ArrayDeque<>();
//
//        int flag1 = 0;
//        int flag2 = 0;
//
//        deque1.add(nums1[0]);
//        deque2.add(nums2[0]);
//        int remainNum = n + m - 2;
//        int i = 1, j = 1;
//        while (i < n && j < m && k - deque1.size() - deque2.size() < remainNum) {
//            if (!deque1.isEmpty() && !deque2.isEmpty() && nums1[i] > deque1.getLast() && nums2[j] > deque2.getLast()) {
//                while(i < n && j < m && !deque1.isEmpty() && !deque2.isEmpty() && (nums1[i]>deque1.getLast() || nums2[j]>deque2.getLast())) {
//                    while (i < n && j < m && !deque1.isEmpty() && !deque2.isEmpty() && k - deque1.size() - deque2.size() < remainNum && nums1[i] > nums2[j] && nums1[i] > deque1.getLast() && nums2[j] > deque2.getLast()) {
//                        deque1.removeLast();
//                    }
//                    while (i < n && j < m && !deque1.isEmpty() && !deque2.isEmpty() && k - deque1.size() - deque2.size() < remainNum && nums1[i] < nums2[j] && nums1[i] > deque1.getLast() && nums2[j] > deque2.getLast()) {
//                        deque2.removeLast();
//                    }
//                    while (i < n && j < m && !deque1.isEmpty() && !deque2.isEmpty() && k - deque1.size() - deque2.size() < remainNum && nums1[i] > deque1.getLast() && nums2[j] > deque2.getLast() && nums1[i] == nums2[j]) {
//                        if (deque1.getLast() >= deque2.getLast()) {
//                            deque2.removeLast();
//                        } else if (deque1.getLast() < deque2.getLast()) {
//                            deque1.removeLast();
//                            //88749  77649  同时为49 任意删除一个
//                        }
//                    }
//                }
//                if(deque1.isEmpty()){
//                    deque1.add(nums1[i]);
//                    i++;
//                    remainNum--;
//                }else if(deque2.isEmpty()){
//                    deque2.add(nums2[j]);
//                    j++;
//                    remainNum--;
//                }else if(!deque1.isEmpty() && !deque2.isEmpty()){
//                    deque1.add(nums1[i]);
//                    deque2.add(nums2[j]);
//                    i++;
//                    j++;
//                    remainNum-=2;
//                }
//            }
//            else if (nums1[i] <= deque1.getLast() && nums2[j] <= deque2.getLast()) {
//                deque1.add(nums1[i]);
//                deque2.add(nums2[j]);
//                i++;
//                j++;
//                remainNum = remainNum - 2;
//            } else {
//                while (i < n && j < m && !deque1.isEmpty() && !deque2.isEmpty() && k - deque1.size() - deque2.size() < remainNum && nums1[i] > deque1.getLast() && nums2[j] <= deque2.getLast()) {
//                    deque1.removeLast();
//                    flag1 = 1;
//                }
//                while (i < n && j < m && !deque1.isEmpty() && !deque2.isEmpty() && k - deque1.size() - deque2.size() < remainNum && nums1[i] <= deque1.getLast() && nums2[j] > deque2.getLast()) {
//                    deque2.removeLast();
//                    flag2 = 1;
//                }
//                if (flag1 == 1) {
//                    deque1.add(nums1[i]);
//                    i++;
//                } else if (flag2 == 1) {
//                    deque2.add(nums2[j]);
//                    j++;
//                }
//                flag1 = 0;
//                flag2 = 0;
//                remainNum--;
//            }
//        }
//
//        while (i < n) {
//            while (i < n && k - deque1.size() - deque2.size() < remainNum && deque1.getLast() < nums1[i]) {
//                deque1.removeLast();
//            }
////                while(i<n && k-deque1.size()-deque2.size()==remainNum){
////                    deque1.add(nums1[i]);
////                    i++;
////                    remainNum--;
////                }
//            deque1.add(nums1[i]);
//            i++;
//            remainNum--;
//        }
//        while (j < m) {
//            while (j < m && k - deque1.size() - deque2.size() < remainNum && deque2.getLast() < nums2[j]) {
//                deque2.removeLast();
//            }
////                while(j<m && k-deque1.size()-deque2.size()==remainNum){
////                    deque2.add(nums2[j]);
////                    j++;
////                    remainNum--;
////                }
//            deque2.add(nums2[j]);
//            j++;
//            remainNum--;
//        }
//        int[] res = new int[k];
//        int z = 0;
//        while (!deque1.isEmpty() && !deque2.isEmpty() && z < k) {
//            Integer peek1 = deque1.peek();
//            Integer peek2 = deque2.peek();
//            if (peek1 < peek2) {
//                res[z] = peek2;
//                deque2.poll();
//            } else if (peek1 >= peek2) {
//                res[z] = peek1;
//                deque1.poll();
//            }
//            z++;
//        }
//
//        while (!deque1.isEmpty() && z < k) {
//            Integer poll = deque1.poll();
//            res[z] = poll;
//            z++;
//        }
//        while (!deque2.isEmpty() && z < k) {
//            Integer poll = deque2.poll();
//            res[z] = poll;
//            z++;
//        }
//        return res;
//    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;

        int start=Math.max(0,k-m);
        int end=Math.min(k,n);

        int[] res=new int[k];

        for(int i=start;i<=end;i++){
            int[] subArr1 = tearDown(nums1, i);
            int[] subArr2 = tearDown(nums2, k - i);
            int[] merge = merge(subArr1, subArr2);

            if(compare(merge,0,res,0)>0){
                res= Arrays.copyOf(merge,k);
            }
        }

        return res;
    }

    public static int[] tearDown(int[] nums,int k){
        if(k==0) return new int[]{};
        int len=nums.length;

        Deque<Integer> deque=new ArrayDeque<>();

        for(int i=0;i<len;i++){
            while(!deque.isEmpty() && deque.size()+len-i>k && deque.getLast()<nums[i]) {
                deque.removeLast();
            }
            deque.add(nums[i]);
        }

        int[] res=new int[k];
        for(int i=0;i<k;i++){
            int poll = deque.poll();
            res[i]=poll;
        }

        return res;
    }

    public static int compare(int[] subArr1,int i,int[] subArr2,int j){
        int n=subArr1.length;
        int m=subArr2.length;
        while(i<n && j<m){
            if(subArr1[i]!=subArr2[j]) return subArr1[i]-subArr2[j];
            i++;
            j++;
        }
        return i==n?0:1;
    }

    public static int[] merge(int[] subArr1,int[] subArr2){
        if(subArr1.length==0) return subArr2;
        if(subArr2.length==0) return subArr1;

        int n=subArr1.length;
        int m=subArr2.length;
        int[] res=new int[m+n];
        int i=0,j=0,z=0;

        while(i<n && j<m){
            if(compare(subArr1,i,subArr2,j)>=0){
                res[z]=subArr1[i];
                z++;
                i++;
            }else if(compare(subArr1,i,subArr2,j)<0){
                res[z]=subArr2[j];
                z++;
                j++;
            }
        }

        while(i<n){
            res[z]=subArr1[i];
            i++;
            z++;
        }

        while(j<m){
            res[z]=subArr2[j];
            j++;
            z++;
        }

        return res;
    }
}
