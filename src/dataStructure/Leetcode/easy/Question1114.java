package dataStructure.Leetcode.easy;
/**
 * @author Yawen Cao
 * @data 2021/10/26 19:31
 */
public class Question1114 {

    test t;
    public Question1114() {
        t=new test();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        t.first(printFirst);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        t.second(printSecond);
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        t.third(printThird);
    }
}
class test{
    boolean firstFinish;
    boolean secondFinish;
    test(){
    }
    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstFinish=true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(!firstFinish){
            wait();
        }
        notifyAll();
        secondFinish=true;
        printSecond.run();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(!secondFinish){
            wait();
        }
        printThird.run();
    }
}