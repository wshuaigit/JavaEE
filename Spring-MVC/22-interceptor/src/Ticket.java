/**
 * ClassName:Ticket
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/17 21:54
 * @Author:wangzhao
 */
public class Ticket {
    private int num = 100;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class MyThread implements Runnable{
    private Ticket ticket = null;
    public MyThread(Ticket ticket){
        this.ticket = ticket;
    }
    @Override
    public void run(){

        while (ticket.getNum() > 0){
            synchronized(this) {
                if(ticket.getNum() > 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket.getNum() + "张票");
                        Thread.sleep(100);
                        ticket.setNum(ticket.getNum() - 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
class MyTest{
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        MyThread myThread = new MyThread(ticket);
        Thread t1 = new Thread(myThread,"售票员1");
        Thread t2 = new Thread(myThread,"售票员2");
        Thread t3 = new Thread(myThread,"售票员3");
        t1.start();
        t2.start();
        t3.start();
    }
}
