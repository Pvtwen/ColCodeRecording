package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2022/1/10 10:31
 */
public class Question306 {
    public boolean isAdditiveNumber(String num) {
        char[] arr = num.toCharArray();
        long[] ret=new long[arr.length];
        return dfs(arr,0,0,ret);
    }
    public boolean dfs(char[] arr,int cur,int idx,long[] ret){
        if(idx==arr.length){
            // 缩小代码量的关键 否则还需要增加 If（cur==0) 和 if(cur==1)
            return cur>2;
        }
        long current=0;
        for(int i=idx;i<arr.length;i++){
            if(arr[idx]=='0' && i>idx) return false;
            // try catch一下
//            String s=new String(arr,idx,i-idx+1);
//            long l = Long.parseLong(s);

            // 该写法防止数据溢出
            current=current*10+ arr[i]-'0';
            if(cur>=2){
                long i1 = ret[cur - 1] + ret[cur - 2];
                if(i1>current) continue;
                else if(current>i1) return false;
            }
            ret[cur]=current;
            if(dfs(arr,cur+1,i+1,ret)){
                return true;
            }
        }
        return false;
    }
//    public boolean isAdditiveNumber(String num) {
//        char[] arr = num.toCharArray();
//        int length = arr.length;
//        if(length<=2) return false;
//        long[] ret= new long[length];
//        return dfs(arr,0,0,ret);
//    }
//    // 第三层开始计算和
//    public boolean dfs(char[] arr,int cur,int idx,long[] ret){
//        // 如果能遍历到最后 直接返回true
//        if(idx==arr.length){
//            return true;
//        }
//        // cur<=1
//        if(cur==0){
//            if(arr[idx]=='0'){
//                ret[cur]=0;
//                boolean dfs = dfs(arr, cur + 1, idx + 1, ret);
//                if(dfs) return true;
//                else return false;
//            }
//            for(int i=0;i<arr.length/2;i++){
//                // substring
//                String s=new String(arr,idx,i+1);
//                ret[cur]=Long.parseLong(s);
//                // 下一次从i+1开始截取
//                boolean dfs = dfs(arr, cur + 1, i + 1, ret);
//                if(dfs) return true;
//            }
//        }
//        else if(cur==1){
//            if(arr[idx]=='0'){
//                ret[cur]=0;
//                boolean dfs = dfs(arr, cur + 1, idx + 1, ret);
//                if(dfs) return true;
//                else return false;
//            }
//            for(int i=idx;i<arr.length-1;i++){
//                String s=new String(arr,idx,i-idx+1);
//                ret[cur]=Long.parseLong(s);
//                boolean dfs = dfs(arr, cur + 1, i + 1, ret);
//                if(dfs) return true;
//            }
//        }
//        else if(cur>1){
//            if(arr[idx]=='0'){
//                if(ret[cur-1]+ret[cur-2]==0) {
//                    ret[cur]=0;
//                    boolean dfs = dfs(arr, cur + 1, idx + 1, ret);
//                    if(dfs) return true;
//                }
//                return false;
//            }
//            // 要计算和
//            for(int i=idx;i<arr.length;i++){
//                String s=new String(arr,idx,i-idx+1);
//                long i1 = Long.parseLong(s);
//                if(ret[cur-1]+ret[cur-2]>i1) continue;
//                // 如果之和大于 直接剪枝
//                else if(ret[cur-1]+ret[cur-2]<i1) break;
//                else{
//                    ret[cur]=i1;
//                    boolean dfs = dfs(arr, cur + 1, i + 1, ret);
//                    if(dfs) return true;
//                }
//        }
//    }
//        return false;
//    }
}
