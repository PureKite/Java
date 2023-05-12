package Ch5;

public class ArrayEx14 {
    // 커맨드라인에서 숫자를 입력해도 숫자가 아닌 문자열로 처리
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("usage: java MorseConverter WORD");
            System.exit(0);
        }
        System.out.println("source:"+args[0]);
        String source= args[0].toUpperCase(); // 대문자로 변환

        String[] morse = {".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--",
                "--.."};
        String result = "";

        for(int i =0; i < source.length(); i++){
            result += morse[source.charAt(i) - 'A'];
        }
        System.out.println("morse:"+result);
    }
}
