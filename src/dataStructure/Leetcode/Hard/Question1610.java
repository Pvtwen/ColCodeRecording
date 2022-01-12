package dataStructure.Leetcode.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/16 10:15
 */
public class Question1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        Integer x = location.get(0);
        Integer y = location.get(1);
        List<Double> polorLocate=new ArrayList<>();
        int cnt=0;
        double pi=Math.PI;
        double angle2 = angle * pi / 180;

        // 遍历points 将值域映射在 -pi,pi内
        for (List<Integer> point : points) {
            double dx = point.get(0) - x;
            double dy = point.get(1) - y;
            // 分情况讨论
            // 如果跟原点重合
            if(dx==0 && dy==0){
                cnt++;
                continue;
            }
            // 如果跟坐标轴重合
            if(dx==0 || dy==0){
                if(dx==0 && dy>0) polorLocate.add(pi/2);
                if(dx==0 && dy<0) polorLocate.add(-pi/2);
                //
                if(dy==0 && dx>0) polorLocate.add(0d);
                if(dy==0 && dx<0) polorLocate.add(-pi);
                continue;
            }
            // 如果是第一象限 直接添加
            if(dx>0 && dy>0) polorLocate.add(Math.atan(dy/dx));
            // 如果是第二象限 加一个pi
            if(dx<0 && dy>0) polorLocate.add(Math.atan(dy/dx)+pi);
            // 如果是第三象限 减一个pi
            if(dx<0 && dy<0) polorLocate.add(Math.atan(dy/dx)-pi);
            // 如果是第四象限 直接添加
            if(dx>0 && dy<0) polorLocate.add(Math.atan(dy/dx));
        }
        // 遍历points 将值域映射在 0,2pi内
//        for (List<Integer> point : points) {
//            double dx = point.get(0) - x;
//            double dy = point.get(1) - y;
//            // 分情况讨论
//            // 如果跟原点重合
//            if(dx==0 && dy==0){
//                cnt++;
//                continue;
//            }
//            if(dy==0 || dx==0){
//                // 如果位于纵坐标上
//                if(dx==0 && dy>0) polorLocate.add(pi/2);
//                if(dx==0 && dy<0) polorLocate.add(3*pi/2);
//                // 如果位于横坐标上
//                if(dy==0 && dx>0) polorLocate.add(0d);
//                if(dy==0 && dx<0) polorLocate.add(pi);
//                continue;
//            }
//            // 如果是第一象限 ,直接添加
//            if(dx>0 && dy>0){
//                double theta = Math.atan(dy / dx);
//                polorLocate.add(theta);
//            }
//            // 如果是第二象限,算出来的theta还要加一个pi
//            if(dx<0 && dy>0){
//                double theta = Math.atan(dy / dx);
//                polorLocate.add(theta+pi);
//            }
//            // 如果是第三象限,算出来的theta还要加一个pi
//            if(dx<0 && dy<0){
//                double theta = Math.atan(dy / dx);
//                polorLocate.add(theta+pi);
//            }
//            //如果是第四象限，算出来的theta还要加一个2pi
//            if(dx>0 && dy<0){
//                double theta = Math.atan(dy / dx);
//                polorLocate.add(theta+2*pi);
//            }
//        }
        Collections.sort(polorLocate);
        int n = polorLocate.size();
        // 防止漏掉一四象限的情况
        for(int i=0;i<n;i++){
            polorLocate.add(polorLocate.get(i)+2*pi);
        }
        for (Double aDouble : polorLocate) {
            System.out.println(aDouble);
        }
        // 滑动窗口
        int i=0,j=1;
        int max=0;
        while (i <= j && j < polorLocate.size()) {
            Double back = polorLocate.get(j);
            Double pre = polorLocate.get(i);
            if (back-pre<=angle2){
                j++;
            }else{
                max=Math.max(max,j-i);
                i++;
            }
        }
        return cnt+max;
    }

//    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
//        Integer x = location.get(0);
//        Integer y = location.get(1);
//        List<Double> polorLocate = new ArrayList<>();
//        int cnt = 0;
//        double pi = Math.PI;
//        // 求弧度 范围是 0,2*pi
//        double angle2=angle*pi/180;
//        for (List<Integer> point : points) {
//            Integer desX = point.get(0) - x;
//            Integer desY = point.get(1) - y;
//            if (desX == 0 && desY == 0) {
//                cnt++;
//                continue;
//            }
//            // 因为arctan2的范围是 -pi,+pi 所以需要加pi 使其范围变成 0,2pi
//            polorLocate.add(Math.atan2(desY,desX)+pi);
//        }
//        // 满足单调递增
//        int n = polorLocate.size();
//        for(int i=0;i<n;i++){
//            polorLocate.add(polorLocate.get(i)+2*pi);
//        }
//        Collections.sort(polorLocate);
//        int max = 0;
//        int i=0,j=1;
//        while(i<=j && j<polorLocate.size()){
//            if(polorLocate.get(j)-polorLocate.get(i)<=angle2){
//                j++;
//            }
//            else{
//                max=Math.max(max,j-i);
//                i++;
//            }
//        }
//        return cnt+max;
//    }
}
