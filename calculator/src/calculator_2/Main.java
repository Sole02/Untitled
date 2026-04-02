package calculator_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("숫자를 입력하세요.");
            int num1 = input.nextInt();
            System.out.print("연산자를 입력하세요.");
            char op = input.next().charAt(0);

            if (!(op == '+' || op == '-' || op == '*' || op == '/')) {
                System.out.println("잘못된 연산자입니다, 다시 입력해주세요.");
                continue;
            }

            System.out.print("숫자를 입력하세요.");
            int num2 = input.nextInt();

            int result = calculator.calculator(num1, op, num2);
            System.out.println("계산 기록: " + calculator.getResults());
            System.out.println("결과: " + result);

            System.out.println("계속하시려면 아무 키를 입력, 종료하시려면 'exit'를 입력하세요.");
            String exit = input.next();
            if (exit.equals("exit")) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}
