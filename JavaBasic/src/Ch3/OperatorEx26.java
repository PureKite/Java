package Ch3;

public class OperatorEx26 {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        
        System.out.println("x는 " + x + "이고, y는 " + y + "일 대, ");
        System.out.println("x | y = " + (x | y));
        System.out.println("x & y = " + (x & y));
        System.out.println("x ^ y = " + (x ^ y));
        
        System.out.println("true | false = " + (true|false));
        System.out.println("true & false = " + (true&false));
        System.out.println("true ^ false = " + (true^false));
        // 논리 연산자는 덧셈 연산자보다 연산 우선순위가 낮기 때문에 괄호 사용
    }
}
