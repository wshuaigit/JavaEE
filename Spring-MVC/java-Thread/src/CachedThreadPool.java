import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName:CachedThreadPool
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 10:38
 * @Author:wangzhao
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();

    }

}
