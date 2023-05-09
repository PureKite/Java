package Ch4;

public class FlowEx16 {
    public static void main(String[] args) {
        // 반복문 안에 또 다른 반복문 가능
        for(int i = 2; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.println(i + " * " + j + " = "+i*j);
            }
        }
    }
}
