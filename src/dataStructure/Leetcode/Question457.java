package dataStructure.Leetcode;

/**
 * @author 86153
 * @data 2021/8/7 15:54
 * 环形数组是否存在循环
 */
public class Question457 {
//    public static boolean circularArrayLoop(int[] arr) {
//        // 用来记录环形数当前指向
//        int index;
//        int length=arr.length;
//        HashSet<Integer> set = new HashSet<>();
//        for(int i=0;i<length;i++){
//            //将指针付给当前开始循环的下标
//            index=i;
//            set.add(index);
//            //如果下标对应的值是数组的长度 则不能构成循环
//            if(Math.abs(arr[i])%length!=0){
//                // 如果开始循环的值是正
//                if(arr[i]>0){
//                    // 根据数值移动下标
//                    index=(arr[index]+index)%length;
//                    // 当循环了一圈之后 跳出循环  如果循环过程中遇到数值为负的值 也跳出循环
//                    //跳出循环的三种情况
//                    // 1. 集合中已经包含该下标 说明循环过该元素
//                    // 2. 对应下标的值小于零
//                    // 3. 下标必须大于起始下标
//                    while(!set.contains(index) && arr[index]>0 && index>i){
//                        set.add(index);
//                        index=(arr[index]+index)%length;
//                    }
//                    // 循环一圈之后 看是否回到起始点
//                    if(index==i){
//                        return true;
//                    }
//                }
//                else{
//                    // -1 相当于向前走了 length-1步
//                    index=(length*(Math.abs(arr[index])/length+1)+arr[index]+index)%length;
//                    while(!set.contains(index) && arr[index]<0 && index>i){
//                        set.add(index);
//                        index=(length*(Math.abs(arr[index])/length+1)+arr[index]+index)%length;
//                    }
//                    if(index%length==i){
//                        return true;
//                    }
//                }
//            }
//            set.clear();
//        }
//        return false;
//    }

    // 双指针 快指针走两步 慢指针走一步
    public static boolean circularArrayLoop(int[] nums) {
        int slow, fast;
        for (int i = 0; i < nums.length; i++) {
            slow = fast = i;
            fast = next(nums, fast);
            // 反向或者是有0元素 则跳出循环
            while (nums[slow] * nums[fast] > 0 && nums[fast] * nums[next(nums, fast)] > 0) {
                // 快慢指针相遇 如果不是自身循环 则返回true；
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            // 如果同方向遇到自身循环 将快慢指针经过的所有元素置为0
            // 如果遇到不同方向 则将快指针之前的所有元素(也有可能包含快指针对应的元素，看奇数个还是偶数个）置为0：
            int rep = i;
            while (nums[rep] * nums[next(nums, rep)] > 0) {
                int temp = rep;
                rep = next(nums, rep);
                nums[temp] = 0;
            }
            nums[rep]=0;
        }
        return false;
    }

    // 返回快指针所对应的下标
    public static int next(int[] nums, int fast) {
        int n = nums.length;
        // 此写法可以应对 正负两种情况
        return (nums[fast] + fast) % n + n;
    }
}
