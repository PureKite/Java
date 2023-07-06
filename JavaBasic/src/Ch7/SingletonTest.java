package Ch7;

final class Singleton {
    private static Singleton s = new Singleton();

    private Singleton(){
        // ...
    }
    public static Singleton getInstance(){
        if(s==null){
            s = new Singleton();
        }
        return s;
    }
    // ...
}
class SingletonTest{
    public static void main(String[] args) {
//        Singleton s = new Singleton(); 에러! prvate 접근
        Singleton s1 = Singleton.getInstance();
    }
}