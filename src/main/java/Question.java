import java.util.Collection;

public interface Question {

    public String getQuestion();
    public void addOption(Character option, String description);
    public Collection<Character> getOptions();
    public boolean isMultiAnswer();
}
