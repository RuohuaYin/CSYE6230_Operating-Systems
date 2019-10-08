import java.util.*;
class FavoriteGenres{
  /**
  newGrad:
  Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

  Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

  The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.

  link: https://leetcode.com/discuss/interview-question/373006
  **/
  public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
    Map<String, List<String>> result = new HashMap<>();

    /*
      song to genre, get(song) -> genre, low complexity
      use a Map<String, String>
      //key: song
      // value: genre
    */
    Map<String, String> songToGenre = new HashMap<>();
    for(Map.Entry<String, List<String>> entry: genreMap.entrySet()){
      for(String song: entry.getValue()){
        songToGenre.put(song, entry.getKey());
      }
    }
    //User - <Genre, Count>
    for(Map.Entry<String, List<String>> entry: userMap.entrySet()){
      String user = entry.getKey();
      Map<String, Integer> count = new HashMap<>();
      int max = 0;
      List<String> songs = entry.getValue();
      for(String song: songs){
        String genre = songToGenre.get(song);
        count.put(genre, count.getOrDefault(genre, 0) + 1);
        max = Math.max(max, count.get(genre));
      }
      result.put(user, new ArrayList<String>());
      for(String genre: count.keySet()){
        if(count.get(genre) == max){
          result.get(user).add(genre);
        }
      }
    }

    //排序

    return result;
  }


  public static void main(String[] args) {
    Map<String, List<String>> userMap = new HashMap<>();
    userMap.put("David", new ArrayList<String>(Arrays.asList("song1", "song2", "song3", "song4", "song8")));
    userMap.put("Emma", new ArrayList<String>(Arrays.asList("song5", "song6", "song7")));
    Map<String, List<String>> genreMap = new HashMap<>();
    genreMap.put("Rock", new ArrayList<String>(Arrays.asList("song1", "song3")));
    genreMap.put("Dubstep", new ArrayList<String>(Arrays.asList("song7")));
    genreMap.put("Techno", new ArrayList<String>(Arrays.asList("song2", "song4")));
    genreMap.put("Pop", new ArrayList<String>(Arrays.asList("song5", "song6")));
    genreMap.put("Jazz", new ArrayList<String>(Arrays.asList("song8", "song9")));

    System.out.println(favoritegenre(userMap, genreMap).toString());

  }
}
