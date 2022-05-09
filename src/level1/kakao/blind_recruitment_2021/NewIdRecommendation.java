package level1.kakao.blind_recruitment_2021;

// 문제 : https://programmers.co.kr/learn/courses/30/lessons/72410
// Level: 1
// 2021 Kakao Blind Recruitment : 신규 아이디 추천
public class NewIdRecommendation {
    public String solution(String new_id) {
        if (passConditions(new_id)) {
            return new_id;
        }

        return getNewIdRecommendation(new_id);
    }

    public String getNewIdRecommendation(String id) {
        id = doFirstStep(id);
        id = doSecondStep(id);
        id = doThirdStep(id);
        id = doForthStep(id);
        id = doFifthStep(id);
        id = doSixthStep(id);
        id = doSeventhStep(id);
        return id;
    }

    // 조건 확인
    public boolean passConditions(String id) {
        return id.matches("^[^.][a-z0-9_.-][^.]${3,15}");
    }

    // 새 아이디 추천 로직
    public String doFirstStep(String id) {
        return id.toLowerCase();
    }

    public String doSecondStep(String id) {
        return id.replaceAll("[^a-z0-9_.-]", "");
    }

    public String doThirdStep(String id) {
        return id.replaceAll("[.]{2,}", ".");
    }

    public String doForthStep(String id) {
        return id.replaceAll("^[.]|[.]$", "");
    }

    public String doFifthStep(String id) {
        return id.isEmpty() ? "a" : id;
    }

    public String doSixthStep(String id) {
        return id.length() > 15 ? doForthStep(id.substring(0, 15)) : id;
    }

    public String doSeventhStep(String id) {
        StringBuilder idBuilder = new StringBuilder(id);
        while (idBuilder.length() <= 2) {
            idBuilder.append(idBuilder.charAt(idBuilder.length() - 1));
        }
        return idBuilder.toString();
    }
}
