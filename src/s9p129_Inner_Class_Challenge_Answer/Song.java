package s9p129_Inner_Class_Challenge_Answer;

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


    public String toString() {
        return title + ": " + duration;
    }

}
