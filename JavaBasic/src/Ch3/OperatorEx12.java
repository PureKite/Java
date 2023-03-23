package Ch3;

public class OperatorEx12 {
    public static void main(String[] args) {
        int a = 1000000 * 1000000 / 1000000;
        int b = 1000000 / 1000000 * 1000000;
        System.out.println(a);
        System.out.println(b);
    }
}
// 먼저 곱하고 나누는 것과 먼저 나누고 곱하는 것의 연산결과가 다름.
// 연산의 순서에 따라 결과가 달라질 수 있다.