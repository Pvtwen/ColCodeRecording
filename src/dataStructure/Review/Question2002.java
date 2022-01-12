package dataStructure.Review;

/**
 * @author Yawen Cao
 * @data 2021/12/13 10:46
 */
public class Question2002 {
    public int maxProduct(String s) {
        int length = s.length();
        int maxValue= (int) Math.pow(2,length)-1;
        int[] record = new int[maxValue];
        int cur=0;
        for(int i=1;i<=maxValue;i++){
            int index=length-1;
            int p = i;
            StringBuilder str=new StringBuilder();
            while(p!=0){
                int i1 = p & 1;
                if(i1==1) str.append(s.charAt(index));
                index--;
                p>>=1;
            }
            StringBuilder copy=new StringBuilder(str);
            if(copy.reverse().toString().equals(str.toString())){
                record[cur] = i;
                cur++;
            }
        }

        // 相交
        int ret=1;
        for(int i=0;i<cur;i++){
            for(int j=i+1;j<cur;j++){
                if((record[i]&record[j])==0){
                    int i1 = Integer.bitCount(record[i]);
                    int i2 = Integer.bitCount(record[j]);
                    ret=Math.max(ret,i1*i2);
                }
            }
        }
        return ret;
    }
}
