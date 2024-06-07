public class SingleChoiceDiscreteAnswerQuestion extends DiscreteAnswerQuestion {
    public SingleChoiceDiscreteAnswerQuestion(String question) {
        super(question);
    }


    @Override
    public boolean isMultiAnswer() {
        return false;
    }
}
