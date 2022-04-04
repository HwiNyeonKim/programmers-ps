package kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * URL : https://programmers.co.kr/learn/courses/30/lessons/72411
 * Level : 1
 * 2021 Kakao Blind Recruitment
 */
public class MenuRenewal {
    static Set<String> courseCandidates;

    public String[] solution(String[] orders, int[] course) {
        List<Course> answer = new ArrayList<>();

        // 주문된 음식 목록
        Set<Character> foodNames = new HashSet<>();
        for (String order : orders) {
            char[] menu = order.toCharArray();
            for (char food : menu) {
                foodNames.add(food);
            }
        }

        // 코스의 음식 갯수별 주문 횟수 확인하기
        for (int foodNumber : course) {
            // 현재 코스의 메뉴 갯수로 조합 가능한 모든 코스 후보 계산
            courseCandidates = new HashSet<>();
            for (String order : orders) {
                boolean[] visited = new boolean[order.length()];
                char[] orderedMenu = order.toCharArray();
                Arrays.sort(orderedMenu);
                combination(orderedMenu, visited, 0, order.length(), foodNumber);
            }
            // 여기부터 courseCandidates에는 주문된 메뉴를 바탕으로 조합 가능한 모든 코스 후보들이 저장되어 있음

            // 각 코스의 메뉴별 주문 횟수 카운팅하기
            List<Course> currentCandidates = new ArrayList<>();
            for (String currentCandidateCourseMenu : courseCandidates) {
                Course courseCandidate = new Course(currentCandidateCourseMenu);
                for (String order : orders) {
                    boolean abandoned = false;
                    for (int i = 0; i < courseCandidate.getCourseMenu().length(); i++) {
                        char menu = courseCandidate.getCourseMenu().charAt(i);
                        if (!order.contains(String.valueOf(menu))) {
                            // 현재 코스메뉴 중 하나라도 주문되지 않은 경우 주문횟수를 증가시키지 않는다.
                            abandoned = true;
                            break;
                        }
                    }

                    if (!abandoned) {
                        courseCandidate.increaseOrderCount();
                    }
                }
                currentCandidates.add(courseCandidate);
            }

            // 코스들 중 최다 주문 코스메뉴 answer에 넣기
            currentCandidates = currentCandidates.stream()
                    .sorted(new CourseOrderCountComparator())
                    .collect(Collectors.toList());
            if (currentCandidates.size() == 0) {
                continue; // 현재 원하는 코스메뉴 갯수로는 코스를 만들 수 없다.
            }

            Course addedCandidate = currentCandidates.remove(0);
            if (addedCandidate.getOrderCount() <= 1) { // 2회 이상 주문된 메뉴 조합만이 코스메뉴가 될 수 있다.
                continue;
            }
            answer.add(addedCandidate);

            boolean termi = false;
            while (!termi && !currentCandidates.isEmpty()) {
                Course currentCandidate = currentCandidates.remove(0);
                if (addedCandidate.getOrderCount() == currentCandidate.getOrderCount()) {
                    answer.add(currentCandidate);
                } else {
                    termi = true;
                }
            }
        }

        return answer.stream()
                .sorted()
                .map(Course::getCourseMenu)
                .toArray(String[]::new);
    }

    static void combination(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            String newCourse = createCourse(arr, visited, n);
            courseCandidates.add(newCourse);
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static String createCourse(char[] arr, boolean[] visited, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}

class CourseOrderCountComparator implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        return o2.getOrderCount() - o1.getOrderCount();
    }
}

class Course implements Comparable<Course> {
    private String courseMenu;
    private int orderCount;

    public Course(String courseMenu) {
        this.courseMenu = courseMenu;
        this.orderCount = 0;
    }

    public String getCourseMenu() {
        return courseMenu;
    }

    public int getOrderCount() {
        return orderCount;
    }

    @Override
    public int compareTo(Course o) {
        return this.courseMenu.compareTo(o.getCourseMenu());
    }

    public void increaseOrderCount() {
        this.orderCount++;
    }
}