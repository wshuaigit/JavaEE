import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * ClassName:TaskWithResult
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 11:01
 * @Author:wangzhao
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call(){
        return "result of TaskWithResult " + id;
    }
}
class CallableDemo{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i=0;i < 10;i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs:results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}