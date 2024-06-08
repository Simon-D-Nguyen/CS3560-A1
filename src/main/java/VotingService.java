import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Class that represents the iVote/mentimeter poll
 * simulation that is specified.
 */
public class VotingService {
    private Question question;
    private final HashMap<Student, Collection<Character>> studentAnswers;
    private final HashMap<Character, Integer> answerStats;


    /**
     * Private method in order to add an answerSet to the
     * stats of the voting service
     * @param answerSet The input/new answerset
     */
    private void addStats(Collection<Character> answerSet) {
        for(Character answer: answerSet) {
            if(answerStats.containsKey(answer)){
                int currentCount = answerStats.get(answer);
                answerStats.replace(answer, currentCount + 1);
            }
            else {
                answerStats.put(answer, 1);
            }
        }
    }


    /**
     * Private method that removes the inputted answer set
     * when a submission is overridden
     * @param answerSet An answer set to remove from the stats.
     */
    private void removeStats(Collection<Character> answerSet) {
        for(Character answer: answerSet) {
            int currentCount = answerStats.get(answer);
            answerStats.replace(answer, currentCount - 1);
        }
    }



    public VotingService() {
        studentAnswers = new HashMap<>();
        answerStats = new HashMap<>();
    }


    /**
     * Sets the question for the voting service, resetting the service's
     * the options and stats
     * @param question Holds the question and valid answers
     */
    public void setQuestion(Question question) {
        this.question = question;
        answerStats.clear();
        studentAnswers.clear();
    }


    /**
     * Returns the options that can answer tha question
     * @return Collection of valid answers to the question
     */
    public Collection<Character> getOptions() {
        return question.getOptions();
    }


    /**
     * Allows a student to submit an answer(set) to the inputted question.
     * Answer(set)s that are not valid are not recorded.
     *
     * @param student object that represents the student.
     * @param answerSet the answers that the student inputs.
     */
    public void submitAnswer(Student student, Set<Character> answerSet) {
        if (question.isValidAnswerSet(answerSet)) {
            if (studentAnswers.containsKey(student)) {
                removeStats(studentAnswers.get(student));
            }

            studentAnswers.put(student, answerSet);
            addStats(answerSet);
        }
    }


    /**
     * Outputs the statistics (how many students voted what) for each
     * option of the question.
     */
    public void outputStatistics() {
        if(question == null) {
            System.out.println("N/A");
        }

        System.out.println(question);
        System.out.println("-> Statistics:");
        for(Map.Entry<Character, Integer> entry: answerStats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }


    /**
     * Outputs Each student's stored answer to the question.
     */
    public void outputStudentAnswers() {
        System.out.println("-> Student Answers:");
        for(Student student: studentAnswers.keySet()){
            System.out.println(student +": " + studentAnswers.get(student));
        }
        System.out.println();
    }

}
