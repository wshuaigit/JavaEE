import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:ThreadSleepTest
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 11:54
 * @Author:wangzhao
 */
public class ThreadSleepTest implements Runnable{

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+":"+start);
        Random ran = new Random();
        try {
            Thread.sleep((ran.nextInt(10)+1)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+":"+end);
        System.out.println(Thread.currentThread().getName()+"..."+(end-start));
    }
}
class MyTest{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
       for(int i=0;i<5;i++){
           exec.execute(new ThreadSleepTest());
       }
       exec.shutdown();
    }
}
