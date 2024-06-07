import java.util.Collection;
import java.util.HashMap;

public abstract class DiscreteAnswerQuestion implements Question{
    private HashMap<Character, String> answers;
    private String question;


    public DiscreteAnswerQuestion(String question) {
        this.answers = new HashMap<>();
        this.question = question;
    }


    public String getQuestion() {
        return question;
    }


    public void addOption(Character option, String description){
        answers.put(option, description);
    }


    public Collection<Character> getOptions(){
        return answers.keySet();
    }
}
