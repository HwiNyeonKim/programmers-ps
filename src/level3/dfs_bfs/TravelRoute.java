package level3.dfs_bfs;

import java.util.*;

// URL: https://programmers.co.kr/learn/courses/30/lessons/43165
// Level: 3
// 깊이/너비 우선 탐색(DFS/BFS) - 여행 경로
public class TravelRoute {
    public static int ticketsLeft;

    public String[] solution(String[][] tickets) {
        ticketsLeft = tickets.length;

        // 1. 공항들의 이름을 오름차순 정렬
        // 오름차순 정렬 ->
        // 가능한 경로가 복수일 경우 알파벳의 오름차순으로 경로를 return
        Set<String> airportNames = new HashSet<>();
        for (String[] ticket : tickets) {
            airportNames.add(ticket[0]);
            airportNames.add(ticket[1]);
        }

        String[] airports = airportNames.stream().sorted().toArray(String[]::new);

        // 2. 계산 편의성을 위한 [공항 이름 - 인덱스] 관계 설정
        Map<String, Integer> nameToIdx = new HashMap<>();
        Map<Integer, String> idxToName = new HashMap<>();
        for (int i = 0; i < airports.length; i++) {
            nameToIdx.put(airports[i], i);
            idxToName.put(i, airports[i]);
        }

        // 3. [출발지 - 도착지] 관계에 대해서, 각 공항에 대한 잔여 방문 횟수 grid 생성
        int[][] grid = new int[airports.length][airports.length]; // [from][to]
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

        // 5. DFS 방식으로 전체 루트를 탐색
        dfs(startingIdx, grid, myRoute);

        // 6. index 값으로 주어진 결과를 String으로 변환
        return myRoute.stream().map(idxToName::get).toArray(String[]::new);
    }

    private void dfs(int currentIdx, int[][] grid, ArrayDeque<Integer> myRoute) {
        int[] currentlyAvailableDestinations = grid[currentIdx];

        for (int i = 0; i < currentlyAvailableDestinations.length; i++) {
            if (currentlyAvailableDestinations[i] != 0) {
                // i = 다음 도착지의 index
                myRoute.offer(i);
                currentlyAvailableDestinations[i]--;
                ticketsLeft--;

                dfs(i, grid, myRoute);

                if (ticketsLeft != 0) {
                    // 목적지에 도착하였으나 티켓이 남았을 경우, 마지막으로 사용했던 티켓을 취소하고 다른 티켓을 먼저 사용하도록 설정
                    currentlyAvailableDestinations[i]++;
                    ticketsLeft++;
                    myRoute.pollLast();
                }
            }
        }
    }
}
