package calculator_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력하세요.");
            int num1 = input.nextInt();
            System.out.print("연산자를 입력하세요.");
            char op = input.next().charAt(0);
            System.out.print("숫자를 입력하세요.");
            int num2 = input.nextInt();

            int result = 0;

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눌 수 없습니다.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                default:
            }
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
