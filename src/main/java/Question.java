import java.util.Collection;
import java.util.Set;

/**
 * Holds the methods for any Question being
 * read by VotingService
 *
 * Utilized an Interface to code by contract
 * and to possibly expand implementation
 */
public interface Question {

    /**
     * Returns the question being asked.
     * @return the String of the question
     */
    public String getQuestion();

    /**
     * Adds an answer option to the question
     * @param option The Character that defines the option
     * @param description The description of the answer
     */
    public void addOption(Character option, String description);

    /**
     * Returns a collection of the options characters
     * @return a collection of characters representing options
     */
    public Collection<Character> getOptions();

    /**
     * Describes if an answer-set is valid
     * @return a boolean value representing if the answer is valid
     */
    public boolean isValidAnswerSet(Set<Character> answerSet);
}
