package dataStructure.Compute.ProducerAndConsumer;

/**
 * @author Yawen Cao
 * @data 2021/11/12 16:47
 */
public class communication {
    public static void main(String[] args) {
        Buffer buffer=new Buffer(2);
        Thread1 t1=new Thread1(buffer);
        t1.start();
        Thread2 t2=new Thread2(buffer);
        t2.start();
    }

}
class Thread1 extends Thread{
    Buffer buffer;
    public Thread1(Buffer buffer){
        this.buffer=buffer;
    }
    public void run(){
        for(int i=1;i<=3;i++){
            buffer.produce();
        }
        System.out.println(buffer.capability);
    }
}
class Thread2 extends Thread{
    Buffer buffer;
    public Thread2(Buffer buffer){
        this.buffer=buffer;
    }
    public void run(){
        for(int i=1;i<=2;i++){
            buffer.consumer();
        }
    }
}
