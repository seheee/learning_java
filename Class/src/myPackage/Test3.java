package myPackage;

public class Test3 extends Test1{
    public Test3() {
        System.out.println("constructor test3");
    }
    public Test3(int num) {
        //test = num;
        super(num);
        System.out.println("constructor test3-2");
    }
    public void printTest1() {
        super.printTest1();
        System.out.println("test3");
    }
}
