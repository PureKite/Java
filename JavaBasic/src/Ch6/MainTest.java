package Ch6;

public class MainTest {
    public static void main(String[] args) {
        main(null); // 자기 자신을 다시 호출한다.
    }
}
// main메서드 역시 자기 자신을 호출하는 것이 가능하며 아무런 조건도 없이 계속해서 자기 자신을 다시 호출하기 때문에 무한호출에 빠짐
// main메서드가 종료되지 않고 호출스택에 계속해서 쌓이게 되므로 결국 호출스택의 메모리 한계를 넘게 되고 StackOverflowError가 발생하여 비정상적으로 종료