public class Test {
    public static void main(String[] args) {
        SubClass s = new SubClass();
    }
}
class SuperClass{
    private int x = 12;
    public SuperClass(){
        System.out.println("SuperClass x = " + x);
        demo();
    }
    public void demo(){
        System.out.println("SuperClass x = " + x);
    }
}
class SubClass extends SuperClass{
    private int x = 99;
    public SubClass(){
        System.out.println("SubClass x = "+x);
    }
    public void func(){
        System.out.println("x = " + x);
    }
    public void demo(){
        System.out.println("SubClass demo x = "+x);
    }
}
