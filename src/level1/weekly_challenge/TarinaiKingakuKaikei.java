package level1.weekly_challenge;

// URL : https://programmers.co.kr/learn/courses/30/lessons/82612
// Level : 1
// 위클리 챌린지 - 부족한 금액 계산하기
public class TarinaiKingakuKaikei {
    public long solution(int price, int money, int count) {
        long needed = price * summationFrom1(count);
        return money >= needed ? 0 : Math.abs(money - needed);
    }

    private long summationFrom1(int to) {
        return (long) (to + 1) * (to / 2) + ((to + 1) / 2) * (to % 2);
    }
}
