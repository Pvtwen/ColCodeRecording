package dataStructure.Leetcode;

import java.util.*;

/**
 * @author 86153
 * @data 2021/9/1 17:48
 */
public class Question721 {
    class UnionFind{
        HashMap<String,Integer> map;
        int[] parent;
        public UnionFind(List<List<String>> accounts){
            parent=new int[accounts.size()];
            map=new HashMap<>();
            for(int i=0;i<parent.length;i++){
                parent[i]=i;
            }
        }
        public int find(int i){
            if(parent[i]!=i)parent[i]=find(parent[i]);
            return parent[i];
        }
        public void union(List<List<String>> accounts,int i,int j){
            int rootx = find(i);
            int rooty = find(j);
            parent[rooty]=rootx;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res=new ArrayList<>();
        UnionFind uf=new UnionFind(accounts);
        int parent=-1,parent1;
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String key = accounts.get(i).get(j);
                if(uf.map.containsKey(key)  && uf.map.get(key)==i){
                    accounts.get(i).remove(j);
                    j--;continue;

                }
                else if(uf.map.containsKey(key) && uf.map.get(key)!=i){
                    if(parent==-1){
                        parent=uf.map.get(key);
                        // uf.parent[i]=parent;
                        uf.union(accounts,parent,uf.parent[i]);
                    }else if(uf.map.get(key)!=parent){
                        uf.union(accounts,parent,uf.map.get(key));
                        // uf.parent[uf.map.get(key)]=parent;
                    }
                    continue;

                }
                uf.map.put(key,i);
            }
            parent=-1;
        }
        for(int i=0;i<accounts.size();i++){
            List<String> list = accounts.get(i);
            parent1 = uf.find(i);
            if(parent1!=i){
                List<String> parent2 = accounts.get(parent1);
                String head1 = parent2.remove(0);
                for(int j=1;j<accounts.get(i).size();j++){
                    if(!parent2.contains(list.get(j))){
                        parent2.add(list.get(j));
                    }
                }
                Collections.sort(parent2);
                parent2.add(0,head1);
            }else{
                String head = list.remove(0);
                Collections.sort(list);
                list.add(0,head);
            }

        }
        for(int i=0;i<accounts.size();i++){
            if(uf.parent[i]==i){
                List<String> list = accounts.get(i);
                res.add(list);
            }
        }
        return res;
    }
}
