package dataStructure.Test.LineAndDot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/10/21 15:59
 */
public class Line {
    List<Dot> dots;
    double k;
    double b;
    
    public Line(Dot dot1,Dot dot2){
        dots=new ArrayList<>();
        dots.add(dot1);
        dots.add(dot2);
        int x1=dot1.postion[0];
        int y1=dot1.postion[1];
        int x2=dot2.postion[0];
        int y2=dot2.postion[1];
        if(x1==x2) k=Double.MAX_VALUE;
        k=(double)(y2-y1)/(x2-x1);
        b=y2-k*x1;
    }

    //点到直线按的距离
    public double distance(Dot dot){
        int x=dot.postion[0];
        int y=dot.postion[1];
        double distance= (Math.abs(y-k*x-b)/Math.sqrt(k*k+1));
        return distance;
    }

    public String printf(int k,int b){
        return "k="+k+" b="+b;
    }
}
