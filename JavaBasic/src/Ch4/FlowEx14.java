package Ch4;

public class FlowEx14 {
    public static void main(String[] args) {
        int sum = 0; // 합계를 저장하기 위한 변수
        int i;  //선언부분을 for문 밖으로 옮겼다.
        for(i = 1; i <= 10; i++){
            sum += i;
        }
        System.out.println(i-1 + " 까지의 합: " + sum);
    }
    // for문의 카운터로 사용되는 변수는 주로 for문의 블럭{} 내에서만 사용하기 때문에,
    // for문 내에 선언해서 for문의 실행이 끝나고 나면 없어지도록 하는 것이 다음에 또 다른 반복문에서 다시 재사용할 수도 있어서
    // 코드를 보다 단순화하는데 도움이 됨
}
