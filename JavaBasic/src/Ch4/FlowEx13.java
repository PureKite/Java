package Ch4;

public class FlowEx13 {
    public static void main(String[] args) {
        int sum = 0;

        for(int i = 1; i <= 10; i++){
            sum += i;
        }
        // System.out.println(i-1 + "까지의 합:"+sum); // 에러 발생!!!
        // i를 for문의 초기화부분에서 선언을 했기 때문에 i가 유효한 영역은 오직 for문 내부뿐인데, for문을 벗어난 곳에서 i를 사용했기 때문이다.
    }
}
