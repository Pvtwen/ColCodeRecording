package dataStructure.Compute.SCAN;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/10 15:24
 */
public class Elevator {
    int curLevel;
    int direction; //1  -1
    // 简单的电梯调度算法
    public void scan(List<Floor> requests){
        Collections.sort(requests, new Comparator<Floor>() {
            @Override
            public int compare(Floor o1, Floor o2) {
                return o1.level-o2.level;
            }
        });
        int cloestLevel=-1;
        Deque<Floor> queue=new ArrayDeque<>();
        // find next
        if(direction==1){
            for(int i=0;i<requests.size();i++){
                if(requests.get(i).level>curLevel){
                    cloestLevel=i;
                    break;
                }
            }
            for(int i=cloestLevel;i<requests.size();i++){
                queue.offer(requests.get(i));
            }
            for(int i=cloestLevel-1;i>=0;i--){
                queue.offer(requests.get(i));
            }
        }else if(direction==-1){
            for(int i=requests.size()-1;i>=0;i--){
                if(requests.get(i).level<curLevel){
                    cloestLevel=i;
                    break;
                }
            }
            for(int i=cloestLevel;i>=0;i--){
                queue.offer(requests.get(i));
            }
            for(int i=cloestLevel+1;i<requests.size();i++){
                queue.offer(requests.get(i));
            }
        }
    }
}
