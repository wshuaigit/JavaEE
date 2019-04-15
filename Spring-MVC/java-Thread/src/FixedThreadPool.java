import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:FixedThreadPool
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 10:47
 * @Author:wangzhao
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
