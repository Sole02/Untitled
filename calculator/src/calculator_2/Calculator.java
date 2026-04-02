package calculator_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);
    private List<Integer> results = new ArrayList<>();

// 속성
    int num1;
    char op;
    int num2;
    int result;

// 생성자
    public Calculator() {
    }

// 기능
    public int calculator(int num1, char op, int num2) {

        if (op == '/') {
            while (num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다, 나누실 숫자를 다시 입력해주세요.");
                num2 = sc.nextInt();
            }
        }

        switch (op) {
            case '+':
                result = num1 + num2;
                results.add(result);
                break;
            case '-':
                result = num1 - num2;
                results.add(result);
                break;
            case '*':
                result = num1 * num2;
                results.add(result);
                break;
            case '/':
                result = num1 / num2;
                results.add(result);
                break;
            default:
        }
        return result;
    }

    void result (int result) {
        this.result = result;
        System.out.println("결과 : " + result);
    }
    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }
}
