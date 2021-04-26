package hash;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> plays4EachGenre = new HashMap<>(); // 각 장르 : 총 재생수 관계
        for (int i = 0; i < genres.length; i++) {
            plays4EachGenre.put(genres[i], plays4EachGenre.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 1. 인기 "장르" 정렬
        PriorityQueue<Genre> bestGenres = new PriorityQueue<>();
        Set<String> genreNames = plays4EachGenre.keySet();
        for (String bestGenre : genreNames) {
            bestGenres.offer(new Genre(bestGenre,  plays4EachGenre.get(bestGenre)));
        }

        // 1-2. 각 장르별 Song 정렬
        Map<String, PriorityQueue<Song>> bestSongs4EachGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            PriorityQueue<Song> pq4Songs = bestSongs4EachGenre.getOrDefault(genres[i], new PriorityQueue<>());
            pq4Songs.offer(new Song(genres[i], plays[i], i));
            bestSongs4EachGenre.put(genres[i], pq4Songs); // is it really best?
        }

        // 2. 각 장르별 최대 2곡까지 뽑기
        List<Integer> answer = new ArrayList<>();
        while (!bestGenres.isEmpty()) {
            Genre currentGenre = bestGenres.poll();
            String currentGenreName = currentGenre.getGenreName();

            PriorityQueue<Song> pq4SongsOfEachGenre = bestSongs4EachGenre.get(currentGenreName);
            int size = Math.min(pq4SongsOfEachGenre.size(), 2);
            for (int i = 0; i < size; i++) {
                answer.add(Objects.requireNonNull(pq4SongsOfEachGenre.poll()).getRegNo());
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class Song implements Comparable<Song> {
    private final String genre;
    private final int plays;
    private final int regNo;

    Song(String genre, int plays, int regNo) {
        this.genre = genre;
        this.plays = plays;
        this.regNo = regNo;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getPlays() {
        return this.plays;
    }

    public int getRegNo() {
        return this.regNo;
    }

    @Override
    public int compareTo(Song o) {
        return o.getPlays() - this.plays;
    }
}

class Genre implements Comparable<Genre> {
    private final String genreName;
    private final int totalPlays;

    Genre(String genreName, int totalPlays) {
        this.genreName = genreName;
        this.totalPlays = totalPlays;
    }

    public String getGenreName() {
        return this.genreName;
    }

    public int getTotalPlays() {
        return this.totalPlays;
    }

    @Override
    public int compareTo(Genre o) {
        return o.getTotalPlays() - this.totalPlays;
    }

    // for Test
    public String toString() {
        return this.genreName + ", total plays : " + this.totalPlays;
    }
}