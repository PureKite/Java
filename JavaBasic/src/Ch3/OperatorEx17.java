package Ch3;

public class OperatorEx17 {
    public static void main(String[] args) {
        float pi = 3.141592f;
        float shortPi = (int)(pi * 1000) / 1000f;

        System.out.println(shortPi);
    }
}
// int/int는 나눗셈의 결과를 반올림을 하는 것이 아니라 버림
