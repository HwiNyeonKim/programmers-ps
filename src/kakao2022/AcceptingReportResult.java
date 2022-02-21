package kakao2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 문제 : https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
// 2022 Kakao Blind Recruitment : 신고 결과 받기
public class AcceptingReportResult {
    Map<String, User> users = new HashMap<>();

    public int[] solution(String[] id_list, String[] reports, int k) {
        // 유저 데이터 초기화
        for (int i = 0; i < id_list.length; i++) {
            users.put(id_list[i], new User(id_list[i], i));
        }

        // 신고 데이터 적용
        for (String report : reports) {
            doReport(report, users);
        }

        // 신고 결과 정리
        users.values()
                .stream()
                .filter(user -> isBlocked(user, k))
                .forEach(User::notifyBlocked);

        // 메일 발송 및 결과 반환
        return users.values()
                .stream()
                .sorted()
                .mapToInt(User::getMailCount)
                .toArray();
    }

    public void doReport(String report, Map<String, User> users) {
        String[] reportData = report.split(" ");
        String reporterName = reportData[0];
        String reportedName = reportData[1];

        User reportedUser = users.get(reportedName);
        reportedUser.addReporter(users.get(reporterName));
    }

    public boolean isBlocked(User user, int k) {
        return user.getReportCount() >= k;
    }
}

class User implements Comparable<User> {
    private final String name;
    private final int order;
    private Set<User> reportedBy;
    private int mailCount;

    public User(String name, int order) {
        this.name = name;
        this.reportedBy = new HashSet<>();
        this.order = order;
        this.mailCount = 0;
    }

    public void addReporter(User user) {
        this.reportedBy.add(user);
    }

    public void addMailCount() {
        mailCount++;
    }

    public void notifyBlocked() {
        this.reportedBy.forEach(User::addMailCount);
    }

    public String getName() {
        return name;
    }

    public int getReportCount() {
        return reportedBy.size();
    }

    public int getOrder() {
        return order;
    }

    public int getMailCount() {
        return mailCount;
    }

    @Override
    public int compareTo(User o) {
        return order - o.getOrder();
    }
}