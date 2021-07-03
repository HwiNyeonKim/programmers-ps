package exercise;

public class NumberOf124Country {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int quotient = n / 3;
            int remainder = n % 3;

            switch (remainder) {
                case 1: case 2:
                    sb.insert(0, remainder);
                    break;
                case 0:
                    sb.insert(0, '4');
                    break;
            }

            n = remainder == 0? quotient - 1 : quotient;
        }

        return sb.toString();
    }
}
