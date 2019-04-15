import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:SingleThreadPool
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 10:51
 * @Author:wangzhao
 */
public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
