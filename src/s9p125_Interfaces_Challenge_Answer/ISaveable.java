package s9p125_Interfaces_Challenge_Answer;

import java.util.List;

public interface ISaveable {

    public List<String> write();


    public void read(List<String> savedValues);

}
