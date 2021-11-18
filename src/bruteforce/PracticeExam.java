package bruteforce;

import java.util.ArrayList;

public class PracticeExam {
    public int[] solution(int[] answers) {
        Student student1 = new Student(new int[] {1, 2, 3, 4, 5}, 1);
        Student student2 = new Student(new int[] {2, 1, 2, 3, 2, 4, 2, 5}, 2);
        Student student3 = new Student(new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 3);

        // 각 학생별 채점
        Student[] students = {student1, student2, student3};
        for (Student student : students) {
            student.marking(answers);
        }

        // 최고점수 확인
        int highestScore = findHighestScore(students);

        // 최고 점수를 받은 학생 탐색
        ArrayList<Integer> topStudentsId = new ArrayList<>();
        for (Student student : students) {
            if (highestScore == student.getScore()) {
                topStudentsId.add(student.getId());
            }
        }

        return topStudentsId.stream().mapToInt(i -> i).toArray();
    }

    private int findHighestScore(Student[] students) {
        int highestScore = 0;
        for (Student student : students) {
            int score = student.getScore();
            if (score > highestScore) {
                highestScore = score;
            }
        }
        return highestScore;
    }
}

class Student {
    private final int[] answerSheet;
    private final int id;
    private int score;

    Student(int[] answerSheet, int id) {
        this.answerSheet = answerSheet;
        this.id = id;
    }

    private boolean checkOneAnswer(int answer, int idx) {
        return (this.answerSheet[idx % this.answerSheet.length] == answer);
    }

    public void marking(int[] ref) {
        int currentScore = 0;
        for (int i = 0; i < ref.length; i++) {
            if (this.checkOneAnswer(ref[i], i)) {
                currentScore++;
            }
        }
        this.score = currentScore;
    }

    public int getScore() {
        return this.score;
    }

    public int getId() {
        return this.id;
    }

}