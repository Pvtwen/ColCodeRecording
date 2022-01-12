package dataStructure.Compute.OS;

/**
 * @author Yawen Cao
 * @data 2021/11/28 20:03
 */
public class MemInit {
    public static void main(String[] args) {
        System.out.println((1<<24)>>12);
    }
    public void mem_init(int mem_size){
        int page_num=mem_size>>12;

        int[][] page=new int[page_num+1][(1<<12)+1];
        for(int i=1;i<=page_num;i++){
            for(int j=(i-1)*(1<<12)+1;j<=i*(1<<12);j++){
                page[i][j]=0;
            }
        }
    }
}
