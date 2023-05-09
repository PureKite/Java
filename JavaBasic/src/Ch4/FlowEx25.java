package Ch4;

public class FlowEx25 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;

        while(true){
            if(sum > 100)
                break; // 11, 12번 줄이 실행되지 않고 while문을 완전히 벗어난다.
            ++i;
            sum += i;
            // end of while
        }
        System.out.println("i=" + i);
        System.out.println("sum=" + sum);
    }
}
