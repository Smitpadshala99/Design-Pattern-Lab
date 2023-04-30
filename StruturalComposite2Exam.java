import java.util.*;

// Composite Design Pattern
// Abstract class that defines the basic structure of a component 
abstract class Song{
    String name;
    float size;
    float duration;

    public Song(String name){
        this.name = name;
    }

    public abstract void displaySongInfo();
    public abstract float displaySongSize();
    public abstract float displaySongDuration();
}

// Concrete class for a leaf component
class Songlist extends Song {

    public Songlist(String name, float s, float d) {
        super(name);
        this.size = s;
        this.duration = d;
    }

    public void displaySongInfo() {
        System.out.println("[ Song name: "+ name + "\tsize " + displaySongSize() + "\tDuration " + displaySongDuration() + " ]");
    }

    public float displaySongSize() {
        return this.size;
    }

    public float displaySongDuration() {
        return this.duration;
    }
    
}

// Concrete class for a composite component 
class Playlist extends Song {

    List<Song> lsl = new ArrayList<Song>();

    public Playlist(String name) {
        super(name);
    }

    public void addSong(Song sl){
        lsl.add(sl);
    }
    
    public void removeSong(Song sl){
        lsl.remove(sl);
    }

    public void displaySongInfo() {
        System.out.println("[ "+ name + "\tsize " + displaySongSize() + "\tduration " + displaySongDuration() + " ]");
        for(Song sl: lsl){
            sl.displaySongInfo();
        }
    }

    public float displaySongSize() {
        this.size = 0; 
        for(Song sl: lsl){
            this.size += sl.displaySongSize();
        }
        return this.size;
    }

    public float displaySongDuration() {
        this.duration = 0; 
        for(Song sl: lsl){
            this.duration += sl.displaySongDuration();
        }
        return this.duration;
    }

}

public class StruturalComposite2Exam {
    public static void main(String[] args) {
    
        Song s1 = new Songlist("Song1", 3.45f, 9.58f);
        Song s2 = new Songlist("Song2", 9.52f, 24.30f);
        Song s3 = new Songlist("Song3", 5.68f, 14.39f);

        Song p1 = new Songlist("Prayer1", 9.12f, 10.24f);
        Song p2 = new Songlist("Prayer2", 14.26f, 21.47f);
        Song p3 = new Songlist("Prayer3", 12.14f, 16.25f);
        
        Playlist bs = new Playlist("Bollywood Songs");
        Playlist p = new Playlist("prayers");
        Playlist fs = new Playlist("Favourite Songs");

        bs.addSong(s1); // song1 add to the Bollywood songs playlist
        bs.addSong(s2); // song2 add to the Bollywood songs playlist
        bs.addSong(s3); // song3 add to the Bollywood songs playlist
        bs.displaySongInfo();  // Display Bollywood Songs Playlist

        p.addSong(p1);  // prayer1 add to the Prayers playlist
        p.addSong(p2);  // prayer2 add to the Prayers playlist
        p.addSong(p3);  // prayer3 add to the Prayers playlist
        p.displaySongInfo();  // Display Prayers Playlist

        fs.addSong(bs); // Adding Bollywood Songs playlist into the Favorite Songs
        fs.addSong(p);  // Adding Prayers playlist into the Favorite Songs
        fs.displaySongInfo();  // Display Favorite Song Playlist
        
    }
}
