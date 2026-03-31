package calculator_2;

public class Calculator {


// 속성
    int num1;
    char op;
    int num2;
    int result;

// 생성자
    public Calculator(int num1, char op, int num2) {
        this.num1 = num1;
        this.op = op;
        this.num2 = num2;
    }

// 기능
    public int calculator() {
        switch (this.op) {
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
                    return 0;
                }
                result = num1 / num2;
                break;
            default:
        }
        return result;
    }

    void result (int result) {
        this.result = result;
        System.out.println("결과 : " + result);
    }
}
