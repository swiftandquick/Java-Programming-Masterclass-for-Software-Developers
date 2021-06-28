package s9p129_Inner_Class_Challenge_Answer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList(); // Initialize SongList by calling its constructor.
    }


    public boolean addSong(String title, double duration) {
        /* Call the add() method inside the SongList inner class, pass in unnamed Song object as argument,
        Song's fields are set with specified title and duration.  */
        return songs.add(new Song(title, duration));
    }


    /* Given track number, check if findSong method inside songList return a non-null song object, if it does,
    * add the object to the playlist.  */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song song = songs.findSong(trackNumber);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        else {
            return false;
        }
    }


    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        /* Call the findSong() method and pass in title to check if it returns a non-null Song object, if it does,
        * that means song should be added.  */
        Song song = songs.findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        else {
            return false;
        }
    }


    private class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if(songs.contains(song)) {
                return false;
            }
            else {
                songs.add(song);
                return true;
            }
        }

        private Song findSong(String title) {
            for(Song song : songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 & index < songs.size()) {
                return songs.get(index);
            }
            else {
                return null;
            }
        }

    }

}
