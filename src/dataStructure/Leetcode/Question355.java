package dataStructure.Leetcode;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/10/16 16:42
 */
public class Question355 {
    HashMap<Integer,List<Integer>> followMap;
    HashMap<Integer,List<int[]>> tweetMap;
    int priority;
    public Question355() {
        followMap=new HashMap<>();
        tweetMap=new HashMap<>();
        priority=0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            List<int[]> list=new ArrayList<>();
            int[] tweet=new int[]{tweetId,priority};
            list.add(tweet);
            tweetMap.put(userId,list);
        }else{
            tweetMap.get(userId).add(new int[]{tweetId,priority});
        }
        priority++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        List<Integer> list=new ArrayList<>();

        //先获取用户自己的推文
        List<int[]> tweetList = tweetMap.get(userId);
        if(tweetList!=null){
            for (int[] tweet : tweetList) {
                int tweetId = tweet[0];
                int priority = tweet[1];
                priorityQueue.offer(new int[]{tweetId,priority});
            }
        }

        // 获取用户关注的推文
        List<Integer> followUserIds = followMap.get(userId);
        if(followUserIds!=null){
            for (Integer followUserId : followUserIds) {
                List<int[]> tweets = tweetMap.get(followUserId);
                for (int[] tweet : tweets) {
                    int tweetId = tweet[0];
                    int priority = tweet[1];
                    priorityQueue.offer(new int[]{tweetId,priority});
                }
            }
        }

        int i=1;
        while(i<=10 && !priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            int tweetId = poll[0];
            list.add(tweetId);
            i++;
        }

        return list;
    }

    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            List<Integer> list=new ArrayList<>();
            list.add(followeeId);
            followMap.put(followerId,list);
        }else{
            List<Integer> list = followMap.get(followerId);
            if(!list.contains(followeeId)) list.add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        int index=0;
        List<Integer> integerList = followMap.get(followerId);
        if(integerList!=null) {
            for (Integer integer : integerList) {
                if (integer == followeeId) {
                    integerList.remove(index);
                    break;
                }
                index++;
            }
        }
    }
}