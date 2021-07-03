package exercise;

public class NumberOf124Country {
    public String solution(int n) {
        return changeFromBase3To124Number(changeFromBase10ToBase3(n));
    }

    public String changeFromBase10ToBase3(int n) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, n % 3);
            n /= 3;
        } while (n > 0);

        return sb.toString();
    }

    public int changeFromBase3ToBase10(String base3) {
        int answer = 0;
        char[] base3Nums = base3.toCharArray();

        for (int index = base3.length() - 1, pow = 0; index >= 0; index--, pow++) {
            answer += (base3Nums[index] - '0') * Math.pow(3, pow);
        }

        return answer;
    }

    public String changeFromBase3To124Number(String base3) {
        StringBuilder sb = new StringBuilder();

        char[] base3Nums = base3.toCharArray();
        int index = base3.length() - 1; // 맨 뒤 숫자부터 계산

        while (index > 0) {
            char ch = base3Nums[index];
            switch (ch) {
                case '0':
                    // 3진법 수에서 0이 발견되면, 124 나라의 숫자에 4를 추가하고
                    // 3잔법 수에서 현재 가리키고 있는 수의 앞까지의 숫자에서 1을 뺀다.
                    sb.insert(0, "4");
                    base3Nums = calcMinusBase3(base3.substring(0, index), 1).toCharArray();
                    index = base3Nums.length;
                    break;
                case '1': case '2':
                    sb.insert(0, ch);
                    break;
            }
            index--;
        }

        if (base3Nums[0] != '0') {
            sb.insert(0, base3Nums[0]);
        }

        return sb.toString();
    }

    public String calcMinusBase3(String base3, int n) {
        // 주어진 3진법 수 base3 에서 n을 뺀 값을 3진법 수로 반환.
        int base10 = changeFromBase3ToBase10(base3);
        return changeFromBase10ToBase3(base10 - n);
    }
}
