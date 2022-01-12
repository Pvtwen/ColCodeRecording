package dataStructure.Leetcode.UVa;


import java.util.Scanner;
/**
 * @author 许湘扬
 * @email  547139255@qq.com
 * @detail Uva572
 */
public class UVa572
{
    public static char[][] graph=new char[100][100];
    public static int[][] vis=new int[100][100];
    public static int cnt,m,n;

    public static void main(String[] args)
    {
        Scanner cin=new Scanner(System.in);
        while(true)
        {
            //------------读取输入-------------
            m=cin.nextInt();
            n=cin.nextInt();
            if (m==0)
                break;
            cin.nextLine();
            for(int i=0;i<m;i++)
            {
                String line=cin.nextLine();
                graph[i]=line.toCharArray();
            }
            //-----------初始化vis数组----------
            for(int i=0;i<m;i++)
                for(int j =0;j<n;j++)
                    vis[i][j]=0;

            cnt=0;
            for(int i=0;i<m;i++)
            {
                for(int j =0;j<n;j++)
                    if(vis[i][j]==0 && graph[i][j]=='@')
                        dfs(i,j,++cnt);
            }
            System.out.println(cnt);
        }
    }
    private static void dfs(int i, int j, int cnt2)
    {
        if(i<0 || i>=m || j<0 || j>=n) //跳出边界
            return ;
        if (graph[i][j]=='*' || vis[i][j]>0) //不过不是@ 或者 @被访问过
            return ;
        vis[i][j]=cnt2;

        //向周围深搜
        for(int di=-1;di<=1;di++)
            for(int dj=-1;dj<=1;dj++)
                if (di!=0 || dj!=0 )
                    dfs(di+i, dj+j, cnt2);
    }
}
