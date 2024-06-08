import java.util.*;

public class SimulationDriver {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Random random = new Random();

        // Create Question
        Question q1 = new SingleChoiceDiscreteAnswerQuestion("Water is wet?");
        q1.addOption('1', "True");
        q1.addOption('2', "False");


        // Configure Voting Service
        VotingService iVote = new VotingService();
        iVote.setQuestion(q1);


        //Create Student IDs
        Student[] students = new Student[10];
        for(int i = 0;  i < students.length; i++) {
            students[i] = new Student(random.nextInt(1000));
        }


        //Create Student Answers
        List<Character> options = iVote.getOptions().stream().toList();
        Character[] studentAnswers = new Character[students.length];

        for(int i = 0;  i < studentAnswers.length; i++) {
            int choice = random.nextInt(options.size());
            studentAnswers[i] = options.get(choice);
        }


        //Submit answers
        for (int i = 0;  i < studentAnswers.length; i++) {
            iVote.submitAnswer(students[i], Arrays.asList(studentAnswers[i]));
        }


        //Voting service output
        iVote.outputStatistics();
    }
}
