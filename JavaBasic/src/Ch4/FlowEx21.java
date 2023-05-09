package Ch4;

public class FlowEx21 {
    public static void main(String[] args) {
        int i = 10;
        while(i >= 0){
            // int i = 10; 만약 i가 while문내에서 초기화된다면, 매 반복마다 i의 값이 10으로 초기화 되므로 무한 반복
            // 반복문에 카운터가 필요한 경우는 while문보다는 for문 사용하는 것이 더 좋음
            System.out.println(i--); // i--는 후위형이기 때문에 i가 출력된 후에 감소
        }
    }
}
