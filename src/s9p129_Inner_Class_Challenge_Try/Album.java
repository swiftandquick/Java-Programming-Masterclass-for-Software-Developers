package s9p129_Inner_Class_Challenge_Try;

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


    public class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            /* song is already on the ArrayList songs.  */
            if(songs.contains(song)) {
                return false;
            }
            /* song is not on ArrayList songs, add it to songs.  */
            else {
                songs.add(song);
                return true;
            }
        }

        private Song findSong(String title) {
            /* Check every index of the songs ArrayList to see if title (String) is equal to one of the object's title.
            * If it is, that means the song is in the songs ArrayList, so I return the song object.  */
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getTitle().equals(title)) {
                    return songs.get(i);
                }
            }
            return null;
        }


        private Song findSong(int trackNumber) {
            /* Track number starts from 1, index starts from 0, so index is trackNumber - 1.  */
            int index = trackNumber - 1;
            /* If index is between 0 and 1 less than songs' size, return the song of the specified index.   */
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            /* Otherwise, the index is out of range.  */
            else {
                return null;
            }
        }

    }

}
