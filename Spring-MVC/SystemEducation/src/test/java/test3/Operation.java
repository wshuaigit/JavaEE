package test3;

public abstract class Operation {

    public abstract double getResult(double numA,double numB) throws Exception;

}

class OperAdd extends Operation{

    @Override
    public double getResult(double numA, double numB) {
        return numA + numB;
    }
}

class OperSub extends Operation{

    @Override
    public double getResult(double numA, double numB) {
        return numA - numB;
    }
}

class OperMul extends Operation{

    @Override
    public double getResult(double numA, double numB) {
        return numA * numB;
    }
}

class OperDiv extends Operation{

    @Override
    public double getResult(double numA, double numB) throws Exception {
        if(numB == 0)
            throw new Exception("除数不能为0!");
        return numA / numB;
    }
}

