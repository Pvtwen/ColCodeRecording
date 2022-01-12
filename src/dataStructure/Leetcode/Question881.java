package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/8/26 10:31
 */
public class Question881 {
//    public int numRescueBoats(int[] people, int limit) {
//        int num=0;
//        Arrays.sort(people);
//        int room;
//        for(int i=0,j=people.length-1;i!=j;){
//            if(people[i]+people[j]>limit){
//                num++;
//                j--;
//            }else if(people[i]+people[j]==limit){
//                num++;
//                i++;
//                j--;
//            }else{
//                i++;
//                j--;
//                room=limit-people[i]-people[j];
//                while(i<=j){
//                    if(people[j]<room){
//                        room-=people[j];
//                        j--;
//                    }else if(people[j]>room){
//                        if(people[i]<room){
//                            room-=people[i];
//                            i++;
//                            while(i<=j){
//                                if(people[i]<room){
//                                    room-=people[i];
//                                    i++;
//                                }else if(people[i]==room){
//                                    num++;
//                                    i++;
//                                    break;
//                                }else{
//                                    num++;
//                                    break;
//                                }
//                            }
//                            break;
//                        }else if(people[i]>room){
//                            num++;
//                            break;
//                        }else{
//                            num++;
//                            i++;
//                            break;
//                        }
//                    }else{
//                        num++;
//                        j++;
//                        break;
//                    }
//                }
//            }
//        }
//        return num;
//    }
public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int num=0,i,j;
    for(j=people.length-1,i=0;i<j;){
        if(people[i]+people[j]>limit){
            num++;
            j--;
        }else{
            num++;
            j--;
            i++;
        }
    }
    // 如果最后还剩一个人
    if(i==j) num++;
    return num;
}
}
