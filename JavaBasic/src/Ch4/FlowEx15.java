package Ch4;

public class FlowEx15 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 0; i <= 10; i += 2){ // i += 2 처럼 카운터의 값을 원하는 만큼 값을 증가시키거나 감소시킬 수 있음
            sum += i; // sum = sum + i;
            System.out.println(i + " : " + sum);
        }
    }
}
