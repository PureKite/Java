package Ch4;

public class FlowEx20 {
    public static void main(String[] args) {
        System.out.println("자, 이제 카운트다운을 시작합니다.");
        for(int i = 10; i >= 0; i--){
            for(int j = 0; j < 1000000000; j++){
                ;
            } // for (int j = 0; j < 1000000000; j++) ;
            // for(int j = 0; j < 1000000000; j++){}
            System.out.println(i); // 매 출력마다 시간 지연
        }
        System.out.println("GAME OVER");
    }
}
