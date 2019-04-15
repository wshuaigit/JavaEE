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
            double result = Operation.getResult(Double.parseDouble(strNumA),Double.parseDouble(strNumB),strOper);
            System.out.println("运算结果："+result);
        }catch (NumberFormatException e){
            System.out.println("请输入合法值!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
       /* try {
            double result = 0;
            if ("+".equals(strOper)) {
                result = Double.parseDouble(strNumA) + Double.parseDouble(strNumB);
            }
            else if ("-".equals(strOper)) {
                result = Double.parseDouble(strNumA) - Double.parseDouble(strNumB);
            }
            else if ("*".equals(strOper)) {
                result = Double.parseDouble(strNumA) * Double.parseDouble(strNumB);
            }
            else if ("/".equals(strOper)) {
                if(Double.parseDouble(strNumB)!=0)
                    result = Double.parseDouble(strNumA) / Double.parseDouble(strNumB);
                else
                    System.out.println("除数不能为0!");
            }else{
                System.out.println("请输入指定运算符!");
                return;
            }
            System.out.println("运算结果:"+result);
        }catch (NumberFormatException e){
            System.out.println("请输入合法值!");
        }*/
    }
}
