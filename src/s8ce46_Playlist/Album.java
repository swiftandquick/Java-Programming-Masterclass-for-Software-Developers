package s8ce46_Playlist;

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


    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            return false;
        }
        else {
            songs.add(new Song(title, duration));
            return true;
        }
    }


    private Song findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                return songs.get(i);
            }
        }
        return null;
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (index >= 0 && index <= songs.size()) {
            playlist.add(songs.get(index));
            return true;
        }
        else {
            return false;
        }
    }


    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song == null) {
            return false;
        }
        else {
            playlist.add(song);
            return true;
        }
    }

}
