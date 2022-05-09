package level1.exercise;

// URL : https://programmers.co.kr/learn/courses/30/lessons/12948
// Level : 1
// 연습문제 - 핸드폰 번호 가리기
public class ConcealingPhoneNumber {
    public String solution(String phone_number) {
        int len = phone_number.length() - 4;
        return phone_number.replaceFirst(String.format("[0-9]{%s}", len), "*".repeat(len));
    }
}
