package Ch9;

import java.awt.*;

public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3, 5);
        Point copy = (Point)original.clone();
        System.out.println(original);
        System.out.println(copy);
    }
}
class Point implements Cloneable{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "x="+x + ", y="+y;
    }
    public Object clone(){
        Object obj = null;
        try{
            obj = super.clone();
        }catch(CloneNotSupportedException e){

        }
        return obj;
    }
}