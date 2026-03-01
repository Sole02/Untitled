import java.util.Scanner;
import java.util.Random;

public class WordGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] word = {"FAKER", "HOME", "SLEEP", "GAME", "MUSIC"}; // 단어 목록
        Random rd = new Random();

        int randomIndex = rd.nextInt(word.length);
        String rdword = word[randomIndex];

        char[] blankspace = new char[rdword.length()];
        int failCount = 0;

        for (int i = 0; i < blankspace.length; i++) {
            blankspace[i] = '_';
        }

        System.out.println("단어를 맞추십시오. (기화: 9번)");

        while (true) {
            for (int i = 0; i < blankspace.length; i++) {
                System.out.print(blankspace[i] + " ");
            }
            System.out.println();

            char guess;
            while (true) {
                System.out.print("철자를 입력하세요: ");
                String input = sc.next().toUpperCase();

                if (input.length() != 1) {
                    System.out.println("한 글자만 입력해 주세요.");
                    continue;
                }
                guess = input.charAt(0);

                if (guess < 'A' || guess > 'Z') {
                    System.out.println("알파벳만 입력 가능합니다.");
                    continue;
                }
                break;
            }

            boolean isCorrect = false;
            for (int i = 0; i < blankspace.length; i++) {
                if (rdword.charAt(i) == guess) {
                    blankspace[i] = guess;
                    isCorrect = true;
                }
            }

            if (!isCorrect) {
                failCount++;
                System.out.println("틀렸습니다. (현재 틀린 횟수: " + failCount + "/9" + ")");
            }

            if (failCount >= 9) {
                System.out.println("게임 오버");
                System.out.println("정답은 " + rdword +" 였습니다");
                break;
            }

            boolean finished = true;
            for (int i = 0; i < blankspace.length; i++) {
                if (blankspace[i] == '_') {
                    finished = false;
                }
            }
            if (finished) {
                System.out.println("정답입니다: " + rdword);
                break;
            }
        }
    }
}
