package dataStructure.Leetcode;

/**
 * @author 86153
 * @data 2021/8/18 11:15
 */
public class Question11 {
    // 双指针
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,mul,max=0;
        while(i!=j){
            // 从两边开始比较 哪边的值小 哪边移动一个
            // 为什么小的可以移动：
            // 1.另一边如果下次移动过程当中遇到一个比该值大的元素，就算这两个元素相乘也比这次相乘要小（横轴距离变短，高度不变)
            // 2. 另一边如果下次移动过程当中遇到一个比该值小的元素，比该值小的这个元素与这个元素相乘也比那一次的乘积小（因为横轴小于等于这次横轴距离，且高度小于这次的高度）
            if(height[i]<height[j]){
                mul=height[i]*(j-i);
                max=mul>max?mul:max;
                i++;
            }else{
                mul=height[j]*(j-i);
                max=mul>max?mul:max;
                j--;
            }
        }
        return max;
    }
}
