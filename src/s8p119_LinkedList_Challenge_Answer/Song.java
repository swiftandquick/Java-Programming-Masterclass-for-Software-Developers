package s8p119_LinkedList_Challenge_Answer;

public class Song {

    private String title;
    private double duration;


    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }


    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }

}
