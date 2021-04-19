package dfs_bfs;

import java.util.*;

public class TravelRoute {
    public String[] solution(String[][] tickets) {
        // 1. 공항들의 이름을 모두 모아 오름차순으로 정렬한다.
        // 오름차순으로 정렬하는 이유는, 문제에 주어진 조건에서 가능한 경로가 복수일 경우
        // 알파벳 순으로 순서가 앞서는 경로를 정답으로 return 하도록 했기 때문이다.
        Set<String> namesOfAirports = new HashSet<>();
        for (String[] ticket : tickets) {
            namesOfAirports.add(ticket[0]);
            namesOfAirports.add(ticket[1]);
        }
        String[] listOfAirports = namesOfAirports.toArray(new String[0]);
        Arrays.sort(listOfAirports);

        // 2. 편의성을 위해 공항 이름 - 인덱스 관계를 만들어준다.
        Map<String, Integer> nameToIdx = new HashMap<>();
        Map<Integer, String> idxToName = new HashMap<>();
        for (int i = 0; i < listOfAirports.length; i++) {
            nameToIdx.put(listOfAirports[i], i);
            idxToName.put(i, listOfAirports[i]);
        }

        // 3. 출발지 - 도착지 관계에 대해서, 각 공항의 잔여 방문 횟수를 의미하는 grid를 만든다.
        int[][] grid = new int[listOfAirports.length][listOfAirports.length]; // [from][to]
        for (String[] ticket : tickets) {
            int fromIdx = nameToIdx.get(ticket[0]);
            int toIdx = nameToIdx.get(ticket[1]);
            grid[fromIdx][toIdx]++;
        }

        // 4. 여행 루트 탐색 준비
        ArrayDeque<Integer> myRoute = new ArrayDeque<>();
        String startingPoint = "ICN";
        int startingIdx = nameToIdx.get(startingPoint);
        myRoute.offer(startingIdx);

        // 5. DFS 방식으로 전체 루트를 탐색한다.
        dfs(startingIdx, grid, myRoute);

        // 6. index 값으로 주어진 결과를 String으로 변환한다.
        int totalVisitCount = tickets.length + 1; // 티켓이 n장일 때, 방문하는 도시는 n+1
        String[] answer = new String[totalVisitCount];
        for (int i = 0; i < totalVisitCount; i++) {
            answer[i] = idxToName.get(myRoute.poll());
        }

        return answer;
    }

    private void dfs(int currentIdx, int[][] grid, ArrayDeque<Integer> myRoute) {
        int[] currentlyAvailableDestinations = grid[currentIdx];

        for (int i = 0; i < currentlyAvailableDestinations.length; i++) {
            if (currentlyAvailableDestinations[i] != 0) {
                // i = 다음 도착지의 index
                myRoute.offer(i);
                currentlyAvailableDestinations[i]--;

                dfs(i, grid, myRoute);

                // TODO: 불필요한 grid 전체 순회가 발생한다. 어떻게 해결?
                if (!checkAllTicketsAreUsed(grid)) {
                    // 목적지에 도착하였으나 티켓이 남았을 경우 진입.
                    currentlyAvailableDestinations[i]++;
                    myRoute.pollLast();
                }
            }
        }
    }

    private boolean checkAllTicketsAreUsed(int[][] grid) {
        // grid의 각 원소는 잔여 방문 횟수를 의미하므로, 모두 0이 되어야 티켓을 모두 소진한 것.
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
