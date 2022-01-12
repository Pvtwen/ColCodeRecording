package dataStructure.Leetcode.Match263;

import java.util.*;

// 1.对于BFS 每一次都是向前探索1步 与DFS不同，DFS先将一个节点的所有子节点摸索完毕
// 所以对于这道题而言，如果步数为1，2，3，4，5都可以到达终点，那么肯定先遍历到step=1，有了这个前提
// 才可以设置flag标志变量 来判断是第几次到达终点
// 2.将步数座位统一变量  单独设置一个函数  这样，就不用在BFS的while循环中还用管totalTIme的计算了
//3. 本题设置的参变量较多 能够想到的变量是 visited，本来想的是boolean[] visited来判断是否走过该节点
// 也想过用二维变量来允许多次走过同一节点 但是没考虑到的是 最多经过一个节点两次 如果走过一个节点两次以上
// 可以放弃走本条路径  剩下的变量 flag,step,distance
public class Question5905 {
	public int secondMinimum(int n, int[][] edges, int time, int change) {
		int length=edges.length;
		ArrayList<Integer>[] nodes=new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			nodes[i]=new ArrayList<>();
		}
		
		for(int i=0;i<length;i++) {
			int nodeA=edges[i][0];
			int nodeB=edges[i][1];
			nodes[nodeA].add(nodeB);
			nodes[nodeB].add(nodeA);
		}

		Queue<Set<Integer>> queue=new ArrayDeque<>();
		HashSet<Integer> set=new HashSet<>();
		set.add(1);
		queue.add(set);

		int step=0;
		int distance=0;
		int flag=0;
		int[] visited=new int[n+1];
		while(!queue.isEmpty()){
			Set<Integer> iterSet = queue.poll();
			distance++;
			set=new HashSet<>();
			for (Integer parentNode : iterSet) {
				for (Integer childNode : nodes[parentNode]) {
					if(childNode==n && distance>step){
						step=distance;
						flag++;
					}
					if(flag==2) return compute(step,time,change);
					if(visited[childNode]<=2) set.add(childNode);
					visited[childNode]++;
				}
			}
			queue.offer(set);
		}
		return 1;
    }

    public int compute(int step,int time,int change){
		int totalTime=0;

		for(int i=1;i<=step;i++){
			if((totalTime/change)%2==1){
				totalTime=(totalTime/change+1)*change;
			}
			totalTime+=time;
		}
		return totalTime;
	}
}
