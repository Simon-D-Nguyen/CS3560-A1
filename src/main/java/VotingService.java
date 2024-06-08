import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VotingService {
    private Question question;
    private Collection<Character> options;
    private HashMap<Student, Collection<Character>> studentAnswers;
    private HashMap<Character, Integer> answerStats;


    private void setOptions() {
        this.options = question.getOptions();
    }


    private void addStats(Collection<Character> answers) {
        for(Character answer: answers) {
            if(answerStats.containsKey(answer)){
                int currentCount = answerStats.get(answer);
                answerStats.replace(answer, currentCount + 1);
            }
            else {
                answerStats.put(answer, 1);
            }
        }
    }


    private void removeStats(Collection<Character> answers) {
        for(Character answer: answers) {
            int currentCount = answerStats.get(answer);
            answerStats.replace(answer, currentCount - 1);
        }
    }



    public VotingService() {
        studentAnswers = new HashMap<>();
    }


    public void setQuestion(Question question) {
        this.question = question;
        setOptions();
    }


    public Collection<Character> getOptions() {
        return question.getOptions();
    }


    public void submitAnswer(Student student, Collection<Character> answers) {
        if(studentAnswers.containsKey(student)){
            removeStats(studentAnswers.get(student));
        }

        studentAnswers.put(student, answers);
        addStats(answers);
    }


    public void outputStatistics() {
        if(question == null) {
            System.out.println("N/A");
        }

        System.out.println(question.getQuestion());
        System.out.println("Statistics:");
        for(Map.Entry<Character, Integer> entry: answerStats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
}
