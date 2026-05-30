/**
 * 나이 출력
 * 문제 설명
 * 머쓱이는 선생님이 몇 년도에 태어났는지 궁금해졌습니다. 2022년 기준 선생님의 나이 age가 주어질 때, 선생님의 출생 연도를 return 하는 solution 함수를 완성해주세요
 * https://school.programmers.co.kr/learn/courses/30/lessons/120820
 */

public class Cote_04 {
class Solution {
    public int solution(int age) {
        int year = 2022;
        int answer = year - age + 1;
        return answer;
    }
}
