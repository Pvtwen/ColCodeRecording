package dataStructure.Compute.ProducerAndConsumer;

/**
 * @author Yawen Cao
 * @data 2021/11/12 16:31
 */
public class Buffer {
    int data;  // 缓存的大小
    int capability; // 当前容量
     // true 可以生产东西
    public Buffer(int data){
        this.data=data;
        this.capability=0;
    }
    public synchronized void produce(){
        // full
        while(capability==data){
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        notifyAll();

        capability+=1;
    }
    public synchronized void consumer(){
        while(capability==0){
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        notifyAll();

        capability-=1;
        notifyAll();
    }
}
