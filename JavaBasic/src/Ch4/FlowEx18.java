package Ch4;

public class FlowEx18 {
    public static void main(String[] args) {
        // 각 반복문이 3번씩 반복하므로 모두 27번(3*3*3) 반복
        for(int i = 1; i <= 3; i++)
            for(int j = 1; j<= 3; j++)
                for(int k = 1; k <= 3; k++)
                    System.out.println(""+i+j+k);
    }
}
