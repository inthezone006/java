import java.util.ArrayList;
import java.io.*;

public class MusicRecommender {
    
    private File musicList;
    private BufferedReader br;
    private BufferedWriter bw;
    
    public MusicRecommender(String musicListFileName) throws IOException {
        musicList = new File(musicListFileName);
        br = new BufferedReader(new FileReader(musicList));
        bw = new BufferedWriter(new FileWriter(musicList, true));
    }
    
    public ArrayList<Music> searchArtists(MusicProfile musicProfile) throws IOException {
        //do something
        
        ArrayList<String> list = new ArrayList<String>();
        String line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        
        ArrayList<Music> returnList = new ArrayList<Music>();
        
        for (int i = 0; i < list.size(); i++){
            String[] splitStr = list.get(i).split("\\s+");
            if (splitStr[1].equals(musicProfile.getPreferredArtist())) {
                Music tempMusic = new Music(splitStr[0], splitStr[1], splitStr[2], Integer.parseInt(splitStr[3]), Integer.parseInt(splitStr[4]));
                returnList.add(tempMusic);    
            }
        }
                
        return returnList;
    }
    
    public ArrayList<Music> genreBasedRecommendation(MusicProfile musicProfile) throws IOException {
        //do something
        
        ArrayList<String> list = new ArrayList<String>();
        String line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        
        ArrayList<Music> returnList = new ArrayList<Music>();
        
        for (int i = 0; i < list.size(); i++){
            String[] splitStr = list.get(i).split("\\s+");
            if (splitStr[2].equals(musicProfile.getPreferredGenre())) {
                Music tempMusic = new Music(splitStr[0], splitStr[1], splitStr[2], Integer.parseInt(splitStr[3]), Integer.parseInt(splitStr[4]));
                returnList.add(tempMusic);    
            }
        }
                
        return returnList;
    }
    
    public ArrayList<Music> BPMBasedRecommendation(MusicProfile musicProfile) throws IOException {
        //do something
        
        ArrayList<String> list = new ArrayList<String>();
        String line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        
        ArrayList<Music> returnList = new ArrayList<Music>();
        
        for (int i = 0; i < list.size(); i++){
            String[] splitStr = list.get(i).split("\\s+");
            if (Integer.parseInt(splitStr[2]) == musicProfile.getPreferredBPM()) {
                Music tempMusic = new Music(splitStr[0], splitStr[1], splitStr[2], Integer.parseInt(splitStr[3]), Integer.parseInt(splitStr[4]));
                returnList.add(tempMusic);    
            }
        }
                
        return returnList;
        
    }
    
    public Music getPopularMusic() throws IOException {
        //do something
        
        ArrayList<String> list = new ArrayList<String>();
        String line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        
        int popularity = 0;
        int theIndex = 0;
        for (int i = 0; i < list.size(); i++){
            String[] splitStr = list.get(i).split("\\s+");
            if (Integer.parseInt(splitStr[5]) > popularity) {
                theIndex = i;
                popularity = Integer.parseInt(splitStr[4]);
            }
        }
        
        String[] theLine = list.get(theIndex).split("\\s+");
        
        
        Music tempMusic = new Music(theLine[0], theLine[1], theLine[2], Integer.parseInt(theLine[3]), Integer.parseInt(theLine[4]));
                
        return tempMusic;
    }
    
    public void saveMusicList() throws IOException {
        //do something
        br.close();
        bw.close();
    }
}