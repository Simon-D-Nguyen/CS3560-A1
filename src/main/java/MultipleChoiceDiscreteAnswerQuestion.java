public class MultipleChoiceDiscreteAnswerQuestion extends DiscreteAnswerQuestion {
    public MultipleChoiceDiscreteAnswerQuestion(String question) {
        super(question);
    }


    @Override
    public boolean isMultiAnswer() {
        return true;
    }
}
