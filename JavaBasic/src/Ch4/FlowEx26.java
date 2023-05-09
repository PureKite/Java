package Ch4;

public class FlowEx26 {
    public static void main(String[] args) {
        for(int i = 0; i <= 10; i++){
            if(i % 3 == 0)
                continue; // 반복문 끝으로 이동, break문과 달리 반복문 전체를 벗어나지 않음
            System.out.println(i);
        }
    }
}
