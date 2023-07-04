package Ch6;

class Data1{
    int value;
}
class Data2{
    int value;

    Data2(int x){ // 매개변수가 있는 생성자
        value = x;
    }
}
public class ConstructorTest {
    public static void main(String[] args) {
        Data1 d1 = new Data1();
//        Data2 d2 = new Data2(); // compile error 발생
    }
}

// Data1에는 정의도어 있는 생성자가 하나도 없으므로 컴파일러가 기본 생성자를 추가해주었지만, Data2에는 이미 생성자 Data2(int x)가 정의되어 있으므로 기본 생성자가 추가되지 않았기 때문