import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0;
        int num2 = 0;
        int result = 0;

        while (true) {
            System.out.println("숫자를 입력하세요.");
            num = sc.nextInt();

            System.out.println("연산자를 입력하세요.");
            char op = sc.next().charAt(0);

            if (!(op == '+' || op == '-' || op == '*' || op == '/')) {
                System.out.println("잘못된 연산자입니다, 다시 입력해주세요.");
                continue;
            }

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
                        continue;
                    }
                    result = num / num2;
                    break;
            }

            System.out.println(num + " " + op + " " + num2 + " = " + result);
            System.out.println("계속 계산 하시겠습니까? (exit 입력 시 종료)");

            String exit = sc.next();
            if (exit.equals("exit")) {
                break;
            }
        }
    }
}