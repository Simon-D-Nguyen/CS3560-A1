import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Abstract class used because both MultipleChoice
 * and SingleChoice have similar implementations and are close
 * in behavior.
 */
public abstract class DiscreteAnswerQuestion implements Question{
    private final HashMap<Character, String> answers;
    private final String question;
    private int maxAnswers; //Count the max number of answers possible


    /**
     * Checks if the entered answerSet contains only valid answers
     * @param answerSet an inputted answer set
     * @return true if answerSet has valid inputs, else false
     */
    private boolean validAnswerSetEntries(Set<Character> answerSet) {
        Set<Character> validSet = answers.keySet();
        return validSet.containsAll(answerSet);
    }


    /**
     * Checks if the entered answerSet is not larger than the maximum
     * number of answers
     * @param answerSet an inputted answer set
     * @return True if the answer set is not empty and not too large, else false
     */
    private boolean validAnswerSetSize(Set<Character> answerSet) {
        return (!answerSet.isEmpty()) && answerSet.size() <= getMaxAnswers();
    }


    public DiscreteAnswerQuestion(String question) {
        this.answers = new HashMap<>();
        this.question = question;
        this.maxAnswers = 0;
    }


    public String getQuestion() {
        return question;
    }


    public void addOption(Character option, String description){
        answers.put(option, description);
        //Used HashMap in since each option should have a
        // unique identifier
        maxAnswers++;
    }


    public Collection<Character> getOptions(){
        return answers.keySet();
    }


    /**
     * Returns the max answers in order to answer the question
     * Utilized in order to differ between different Question Types
     * (Multiple vs. Single vs. New ones) by overriding output.
     *
     * @return an int value of the max values
     */
    public int getMaxAnswers() {
        return maxAnswers;
    }


    public boolean isValidAnswerSet(Set<Character> answerSet) {
        return validAnswerSetSize(answerSet) && validAnswerSetEntries(answerSet);
    }
}
