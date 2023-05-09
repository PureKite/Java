package Ch4;

public class FlowEx17 {
    public static void main(String[] args) {
        // for문, while문, if문의 수행할 문장이 하나일 경우 중괄호 {} 생략 가능
        for(int i =2; i <= 9; i++)
            for(int j = 1; j <= 9; j++)
                System.out.println(i + "*" + j + " = " + i * j);
    }
}
