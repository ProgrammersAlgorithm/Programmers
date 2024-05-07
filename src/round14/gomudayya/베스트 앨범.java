import java.util.*;
import java.util.stream.*;

class Solution {
    Map<String, Integer> play = new HashMap<>();    // <장르, 재생횟수>
    Map<String, List<Song>> song = new HashMap<>(); // <장르, 노래목록(고유번호)>
    
    List<Integer> answer = new ArrayList<>();
    
    public int[] solution(String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i++) {
            play.merge(genres[i], plays[i], (v1, v2) -> v1+v2);
            
            List<Song> list = song.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Song(i, plays[i]));
            song.put(genres[i], list);
        }
        
        for (String genre: sortGenreByPlay(play)) {
            List<Integer> pickedSongIds = pickSongIds(song.get(genre));
            answer.addAll(pickedSongIds);
        }

        return answer.stream()
            .mapToInt(n -> n)
            .toArray();
    }
    
    List<String> sortGenreByPlay(Map<String, Integer> play) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(play.entrySet());
        Collections.sort(list, (entry1, entry2) -> entry2.getValue() - entry1.getValue());
        return list.stream()
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
    }
    
    List<Integer> pickSongIds(List<Song> songs) {
        if (songs.size() == 1) return List.of(songs.get(0).id);
        
        Collections.sort(songs);
        return Arrays.asList(songs.get(0).id, songs.get(1).id);
    }
}

class Song implements Comparable<Song> {
    int id;
    int play;
    
    public Song(int id, int play) {
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Song o) {
        int comp = o.play - this.play;
        if (comp == 0) return this.id - o.id;
        return comp;
    }
}
