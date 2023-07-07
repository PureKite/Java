package Ch7;

public class InterfaceTest3 {
    public static void main(String[] args) {
        A3 a = new A3();
        a.methodA();
    }
}
class A3{
    void methodA(){
        I3 i = InstanceManger.getInstance();
        i.methodB();
    }
}
interface I3{
    public abstract void methodB();
}
class B3 implements I3{
    public void methodB(){
        System.out.println("methodB in B class");
    }
}
class InstanceManger{
    public static I3 getInstance(){
        return new B3();
    }
}
