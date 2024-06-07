import java.util.HashMap;

public abstract class Question {
    private HashMap<Character, String> questions;



    public void addQuestion(Character option, String description){
        questions.put(option, description);


    }
}
