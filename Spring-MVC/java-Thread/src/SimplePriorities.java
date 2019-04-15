import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:SimplePriorities
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 16:18
 * @Author:wangzhao
 */
public class SimplePriorities implements Runnable{
    private int countDown = 5;
    private volatile double d;
    private int priority;
    public SimplePriorities(int priority){
        this.priority = priority;
    }
    @Override
    public String toString(){
        return Thread.currentThread()+":"+countDown;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true){
            for(int i=1;i<10000;i++){
                d += (Math.PI + Math.E) /(double)i;
                if(i % 10000 == 0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown == 0)
                return;
        }
    }
}

class MyTest1{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute( new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
