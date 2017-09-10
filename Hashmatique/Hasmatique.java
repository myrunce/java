import java.util.HashMap;
public class Hasmatique{
    public static void devonSongs(){
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("Song 1", "This is the lyrics to Song 1");
        trackList.put("Song 2", "This is the lyrics to Song 2");
        trackList.put("Song 3", "This is the lyrics to Song 3");
        trackList.put("Song 4", "This is the lyrics to Song 4");
        for(String key : trackList.keySet()) {
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}