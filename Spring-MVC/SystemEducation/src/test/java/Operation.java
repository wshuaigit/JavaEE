public class Operation {

    public static double getResult(double numA,double numB,String oper) throws Exception {
        double result = 0;
        switch (oper){
            case "+":
                result = numA + numB;
                break;
            case "-":
                result = numA - numB;
                break;
            case "*":
                result = numA * numB;
                break;
            case "/":
                if(numB != 0) {
                    result = numA / numB;
                }else{
                    throw new Exception("除数不能为0!");
                }
                break;
            default:
                throw new Exception("请输入指定运算符!");
        }
        return result;
    }
}
