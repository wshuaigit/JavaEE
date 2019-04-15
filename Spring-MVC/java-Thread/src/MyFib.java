import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ClassName:MyFib
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 11:26
 * @Author:wangzhao
 */
public class MyFib {
    private int n;
    public MyFib(int n){
        this.n = n;
    }
    public int getSum(){
       if(n == 1){
           return 1;
       }
       if(n == 2){
           return 2;
       }
       int a = 1;
       int b = 1;
       int sum = 2;
       for(int i=3;i<=n;i++){
            a = a+b;
            sum += a;
            b = a - b;

       }
       return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=1;i<=5;i++){
            list.add(exec.submit(new MyCallable(new MyFib(i))));
        }
        exec.shutdown();
        for(Future<Integer> future : list)
            System.out.println(future.get());

    }
}

class MyCallable implements Callable<Integer>{

    private MyFib fib;
    public MyCallable(MyFib fib){
        this.fib = fib;
    }
    @Override
    public Integer call() throws Exception {
        return fib.getSum();
    }
}
