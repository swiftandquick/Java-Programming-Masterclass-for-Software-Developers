package s8p119_LinkedList_Challenge_Try;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs = new ArrayList<Song>();


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<Song>();
    }

    /*
    public String getName() {
        return name;
    }


    public String getArtist() {
        return artist;
    }


    public ArrayList<Song> getSongs() {
        return songs;
    }
    */

    /* If the Song object doesn't exist in the songs ArrayList, return false.  Otherwise, add the Song. */
    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            return false;
        }
        else {
            songs.add(new Song(title, duration));
            return true;
        }
    }


    /* Find the song based on title, if it exists, return the Song object, otherwise return null.  */
    private Song findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                return songs.get(i);
            }
        }
        return null;
    }


    /* If trackNumber > 0 and song exists, return true.  */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        /* If index is within range, means between 1 and size of songs, add the song.  */
        if (index >= 0 && index <= songs.size()) {
            playlist.add(songs.get(index));
            return true;
        }

        else {
            return false;
        }
    }


    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        /* Find song base on title.  */
        Song song = findSong(title);

        /* If song doesn't exist, don't add.  */
        if (song == null) {
            return false;
        }

        else {
            playlist.add(song);
            return true;
        }
    }

}
