package dataStructure.Leetcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/10/1 10:36
 */
public class Question1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> head=new HashSet<>();
        for (List<String> path : paths) {
            head.add(path.get(0));
        }
        for (List<String> path : paths) {
            String ter = path.get(1);
            if(!head.contains(ter)) return ter;
        }

        return null;
    }
}
