package dataStructure.Queue;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/6/10 18:42
 */
public class SeqQueue implements myQueue {
    static final int defaultSize=10;
    int front;
    int rear;
    int count;
    int maxSize;
    Object[] data;

    public SeqQueue(){
        data=new Object[defaultSize];
        maxSize=defaultSize;
        count=front=rear=0;
    }

    public SeqQueue(int size){
        data=new Object[size];
        maxSize=size;
        count=front=rear=0;
    }

    //
    @Override
    public void append(Object object) throws Exception {
        if(rear==front && count>0){
            maxSize+=defaultSize;
            data = Arrays.copyOf(data, maxSize);
            rear=count;
        }
        data[rear]=object;
        rear=(rear+1)%maxSize;
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if(count==0){
            throw new Exception("队列为空");
        }
        Object object=data[front];
        front=(front+1)%maxSize;
        count--;
        return object;
    }

    @Override
    public Object getFront() throws Exception {
        if(count==0){
            throw new Exception("队列为空");
        }
        return data[front];
    }

    public Object getRear() throws Exception {
        if(count==0){
            throw new Exception("队列为空");
        }
        if(rear==0){
            return data[count-1];
        }
        return data[rear-1];
    }
    @Override
    public boolean notEmpty() {
        return count != 0;
    }
}
