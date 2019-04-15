package test3;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字A:");
        String strNumA = scanner.nextLine();
        System.out.print("请输入数字B:");
        String strNumB = scanner.nextLine();
        System.out.print("请输入运算符:");
        String strOper = scanner.nextLine();


        try {
            //生成工厂对象
            OperFactory factory = new OperFactory();
            //生成合适的子类对象
            Operation oper = factory.createOper(strOper);
            //利用多态进行计算
            double result = oper.getResult(Double.parseDouble(strNumA),Double.parseDouble(strNumB));
            System.out.println("运算结果:"+result);
        }catch (NumberFormatException e){
            System.out.println("请输入合法数字！");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
