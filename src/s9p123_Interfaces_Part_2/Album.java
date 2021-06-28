package s9p123_Interfaces_Part_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }


    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        else {
            return false;
        }
    }


    private Song findSong(String title) {
        for (Song song : this.songs) {
            if(song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }


    /* LinkedList is changed to List.  */
    public boolean addToPlayList(int trackNumber, List<Song> playlist) {
        int index = trackNumber - 1;
        if((index >= 0) && (index <= songs.size())) {
            playlist.add(songs.get(index));
            return true;
        }
        else {
            System.out.println("This album does not have track " + trackNumber + ".  ");
            return false;
        }
    }


    /* Changed LinkedList to List.  */
    public boolean addToPlayList(String title, List<Song> playlist) {
        Song song = findSong(title);
        if(song != null) {
            playlist.add(song);
            return true;
        }
        else {
            System.out.println("The song " + title + " is not in this album.  ");
            return false;
        }
    }

}
