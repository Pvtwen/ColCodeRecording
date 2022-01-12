package dataStructure.UnionFindSet;

/**
 * @author 86153
 * @data 2021/8/21 10:43
 */
public class exception {
    static int[] fa;
    public static void init(int n){
        fa=new int[n+1];
        for(int i=1;i<=n;i++){
            fa[i]=i;
        }
    }

    public static void union(int i,int j){
        //找到i的祖先
        int i_fa=find(i);
        //j的祖先
        int j_fa=find(j);
        fa[i_fa]=j_fa;
    }

    public static int find(int i){
        if(i==fa[i]) return i;
        else{
            //路径压缩
            fa[i]=find(fa[i]);  //找到根节点 并将根节点作为其父节点
            return fa[i];       //返回父节点
        }
    }
}
