package Ch7;

public class PointTest2 {
    public static void main(String[] args) {
        Point_3D p3 = new Point_3D();
        System.out.println("p3.x=" + p3.x);
        System.out.println("p3.y=" + p3.y);
        System.out.println("p3.z=" + p3.z);
    }
}
class Point3{
    int x = 10;
    int y = 20;

    Point3(int x, int y){
        // 생성자 첫 줄에서 다른 생성자를 호출하지 않기 때문에 컴파일러가 'super();'를 여기에 삽입
        this.x = x;
        this.y = y;
    }
}
class Point_3D extends Point3{
    int z = 30;
    Point_3D(){
        this(100, 200, 300);
    }
    Point_3D(int x, int y, int z){
        super(x, y);
        this.z = z;
    }
}