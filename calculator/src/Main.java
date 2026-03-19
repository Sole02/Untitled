import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int num2 = 0;

        System.out.println("숫자를 입력하세요.");
        num = sc.nextInt();

        System.out.println("연산자를 입력하세요.");
        char op = sc.next().charAt(0);

        System.out.println("숫자를 입력하세요.");
        num2 = sc.nextInt();
    }
}
