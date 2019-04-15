/**
 * ClassName:Fibonacci
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 10:29
 * @Author:wangzhao
 */
public class Fibonacci implements Runnable{
    private int n;
    public Fibonacci(int n){
        this.n = n;
    }

    @Override
    public void run() {
        int a = 1;
        int b = 1;
        if(n == 1)
            System.out.print(1 +" ");
        if(n>=2)
            System.out.print(1 +" " + 1+" ");
        for(int i=3;i<=n;i++){
            a = a + b;
            System.out.print(a+" ");
            b = b + a;
            System.out.print(b+" ");
        }
    }

    public static void main(String[] args) {
        for(int i=3;i<=5;i++){
            new Thread(new Fibonacci(i)).start();
        }
    }
}
