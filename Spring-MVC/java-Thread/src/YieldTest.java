/**
 * ClassName:YieldTest
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/18 10:19
 * @Author:wangzhao
 */
public class YieldTest extends Thread{
    public YieldTest(String name){
        super(name);
    }
    public void run(){
        for(int i=1;i<=50;i++){
            System.out.println(""+getName()+"-----"+i);
            if(i==30){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest t1 = new YieldTest("张三");
        YieldTest t2 = new YieldTest("李四");
        t1.setPriority(6);
        t1.start();
        t2.start();

    }
}
