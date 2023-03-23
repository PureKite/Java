package Ch3;

public class OperatorEx14 {
    public static void main(String[] args) {
        char c1 = 'a';

        // char c2 = c2 + 1;  컴파일 에러 발생! => int로 자동 형변환되기 때문에 char로 다시 형변환
        char c2 = 'a'+1; // 컴파일 에러 없음 => 리터럴 간의 연산이기 때문
        System.out.println(c2);
    }
}
