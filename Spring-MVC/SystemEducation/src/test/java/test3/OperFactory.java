package test3;

public class OperFactory {
    public static Operation createOper(String strOper) throws Exception {
        Operation oper = null;
        switch (strOper){
            case "+":
                oper = new OperAdd();
                break;
            case "-":
                oper = new OperSub();
                break;
            case "*":
                oper = new OperMul();
                break;
            case "/":
                oper = new OperDiv();
                break;
            default:
                throw new Exception("请输入指定运算符");
        }
        return oper;
    }
}
