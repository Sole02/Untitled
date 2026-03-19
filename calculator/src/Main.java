import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0;
        int num2 = 0;
        int result = 0;

        System.out.println("숫자를 입력하세요.");
        num = sc.nextInt();

        System.out.println("연산자를 입력하세요.");
        char op = sc.next().charAt(0);

        System.out.println("숫자를 입력하세요.");
        num2 = sc.nextInt();

        switch (op) {
            case '+':
                result = num + num2;
                break;
            case '-':
                result = num - num2;
                break;
            case '*':
                result = num * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                }
                result = num / num2;
                break;
            default:
                System.out.println("잘못된 연산자입니다, 다시 입력해주세요.");
                return;
        }

        System.out.println(num + " " + op + " " + num2 + " = " + result);
    }
}
