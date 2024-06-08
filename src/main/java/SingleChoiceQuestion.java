/**
 * Represents single choice questions, where only one choice can be Chosen
 */
public class SingleChoiceQuestion extends DiscreteAnswerQuestion {
    public SingleChoiceQuestion(String question) {
        super(question);
    }


    /**
     * Single Choice has a maximum of 1 answer availible
     */
    @Override
    public int getMaxAnswers() {
        return 1;
    }
}
