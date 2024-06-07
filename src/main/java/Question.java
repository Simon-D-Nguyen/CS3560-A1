import java.util.HashMap;

public abstract class Question {
    private HashMap<Character, String> options;
    private String question;


    public Question(String question) {
        this.options = new HashMap<>();
        this.question = question;
    }


    public String getQuestion() {
        return question;
    }


    public void addOption(Character option, String description){
        options.put(option, description);
    }
}
