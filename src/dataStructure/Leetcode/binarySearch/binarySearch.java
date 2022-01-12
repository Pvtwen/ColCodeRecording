package dataStructure.Leetcode.binarySearch;

/**
 * @author Yawen Cao
 * @data 2021/11/21 15:44
 */
public class binarySearch {
    // 查找第一个大于等于元素的下标
    public void bsForFirstGT(int[] arr,int find){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(l==r) break;
            else if(arr[mid]<find) l=mid+1;
            else if(arr[mid]>=find) r=mid;
        }
        if(arr[l]>find) System.out.println("找不到该元素,但是第一个大于等于该元素的下表为 "+l);
        else if(arr[l]==find) System.out.println("该元素的下标"+l);
        else System.out.println("数组中的所有元素全部小于find");
    }

    // 找第一个大于元素的下标
    public void bsForFirstG(int[] arr,int find){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(l==r) break;
            else if(arr[mid]<=find) l=mid+1;
            else if(arr[mid]>find) r=mid;
        }
        if(arr[l]<=find) System.out.println("找不到第一个大于该元素的值");
        else System.out.println(l);
    }
    // 查找第一个小于等于元素的下标
    public void bsForLast(int[] arr,int find){
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(l==r || l==r-1) break;
            else if(arr[mid]<=find) l=mid;
            else if(arr[mid]>find) r=mid-1;
        }
        if(arr[r]<=find) System.out.println(r);
        else System.out.println(l);
    }
}
