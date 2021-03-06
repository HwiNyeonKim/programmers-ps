package level2.stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// URL: https://programmers.co.kr/learn/courses/30/lessons/42584
// Level: 2
// 스택/큐 - 주식 가격
public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // initialize
        Stack<Integer> stocks = new Stack<Integer>();
        List<Integer> done = new ArrayList<Integer>();
        for (int price : prices) {
            stocks.push(price);
        }

        while (!stocks.isEmpty()) {
            int currentStock = stocks.pop();
            int stocksSize = stocks.size();
            int doneSize = done.size();

            // 현재 선택된 주식이 언제까지 가격이 떨어지지 않는지 계산
            for (int i = doneSize - 1; i >= 0; i--) {
                // i = 0 부터 할 시 매 턴 마다 element이 발생하여 비효율적
                int comp = done.get(i);

                if (currentStock > comp) {
                    answer[stocksSize] = doneSize - i;
                    break;
                }
            }

            if (answer[stocksSize] == 0) {
                answer[stocksSize] = doneSize;
            }

            done.add(currentStock); // 현재 선택된 주식에 대한 계산 완료
        }
        return answer;
    }
}
