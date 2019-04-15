import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * ClassName:ThreadTest01
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/17 23:09
 * @Author:wangzhao
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(new MyThread()).start();
        }
    }
}
class MyThread implements Runnable{
    public MyThread(){
        System.out.println("创建线程对象");
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}
