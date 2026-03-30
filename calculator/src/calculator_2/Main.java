package calculator_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("숫자를 입력하세요.");
        int num1 = input.nextInt();
        System.out.println("연산자를 입력하세요.");
        char op = input.next().charAt(0);
        System.out.print("숫자를 입력하세요.");
        int num2 = input.nextInt();

    }
}
