package dataStructure.Test.Movie;

import dataStructure.Test.Node;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/15 19:51
 */
public class sortMovie {
    //
    public HashMap<String,TreeMap<String,List<String>>> movieSort2(movie[] movies){
        HashMap<String,Map<String,List<String>>> map=new HashMap<>();
        HashMap<String, TreeMap<String, List<String>>> ret = new HashMap<>();
        for (movie movie : movies) {
            String genere = movie.getGenere();
            String name = movie.getName();
            String tag = movie.getTag();
            String[] generes = genere.split("|");
            for (String gene : generes) {
                Map<String, List<String>> m = map.getOrDefault(gene, new HashMap<>());
                List<String> list = m.getOrDefault(tag, new ArrayList<>());
                list.add(name);
                m.put(tag,list);
                map.put(gene,m);
            }
            // 每个类别下面 选电影量最高的前50个标签对应的电影列表
            for (Map.Entry<String, Map<String, List<String>>> entry : map.entrySet()) {
                String ge = entry.getKey();
                Map<String, List<String>> map1 = entry.getValue();
                TreeMap<String,List<String>> treeMap=new TreeMap<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return map1.get(o2).size()-map1.get(o1).size();
                    }
                });
                for (Map.Entry<String, List<String>> listE : map1.entrySet()) {
                    String key = listE.getKey();
                    List<String> value = listE.getValue();
                    treeMap.put(key,value);
                }
                int count=1;
                for (Map.Entry<String, List<String>> stringListEntry : treeMap.entrySet()) {
                    if(count==50) break;
                }
            }
        }
        return ret;
    }
    //
    public List<List<String>> movieSort(movie[] movies) {
        // tags: listmovies  含电影数量最多的前五十个标签
        HashMap<String, List<String>> map = new HashMap<>();
        for (movie mov:movies) {
            // 将电影的类别和电影名 放入哈希表中
            String genere = mov.getGenere();
            String movieName = mov.getName();
            List<String> list = map.getOrDefault(genere, new ArrayList<>());
            list.add(movieName);
            map.put(genere, list);
        }

        // 遍历完之后 获取前50个包含电影信息最多的电影列表
        List<List<String>> res=new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }

        Collections.sort(res, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o2.size()-o1.size();
            }
        });
        List<List<String>> subList = res.subList(0, 50);
        return subList;
    }
}
