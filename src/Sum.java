import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        // 입력: 키보드로 두개의 수를 입력으로 받는다.
        // 출력: 화면에 두개의 수의 합을 출력한다.
        Scanner s2 = new Scanner(System.in);

        int a, b;
        String first, second;
        System.out.println("두개의 숫자를 입력해 주세요");
        first = s2.next();
        second = s2.next();
        System.out.println(first+ ", "+second);

        a = Integer.parseInt(first);
        b = Integer.parseInt(second);
        //System.out.println("두 수의 합은 "+(a + b)+"입니다.");
        System.out.printf("%d와 %d의 합은 %d입니다.", a, b, a+b);
        s2.close();

//        System.out.println("더하고 싶은 숫자 두개를 입력하세요 ex) 2,3");
//        Scanner s1 = new Scanner(System.in);

//        String inputValue = s1.nextLine();
//        String[] valueArray = inputValue.split(",");
//        int firstNum = Integer.parseInt(valueArray[0]);
//        int secondNum = Integer.parseInt(valueArray[1]);

//        System.out.println(firstNum + secondNum);
    }
}
