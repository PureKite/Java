package Ch7;

public class CastingTest1 {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe; // car = (Car)fe;에서 형변환이 생략된 형태
        // car.water();
        fe2 = (FireEngine)car; // 자손타입 <- 조상타입
        fe2.water();
    }
}
class Car{
    String color;
    int door;

    void drive(){
        System.out.println("drive, Brrr~");
    }

    void stop(){
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car{
    void water(){
        System.out.println("water!!!");
    }
}
