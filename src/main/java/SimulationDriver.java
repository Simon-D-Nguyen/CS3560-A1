import java.util.*;

public class SimulationDriver {

    public static void main(String[] args) {

        Random random = new Random();

        // Create Question
        System.out.println("--- Single-Choice Question ---");
        Question q1 = new SingleChoiceQuestion("Water is wet?");
        q1.addOption('1', "True");
        q1.addOption('2', "False");


        // Configure Voting Service
        VotingService iVote = new VotingService();
        iVote.setQuestion(q1);


        //Create Student IDs
        Student[] students = new Student[20];
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
            iVote.submitAnswer(students[i], new HashSet<>(Arrays.asList(studentAnswers[i])));
        }

        //Voting service output
        iVote.outputStatistics();
        iVote.outputStudentAnswers();




        // Create Question
        System.out.println("--- Single-Choice Question ---");
        Question q2 = new SingleChoiceQuestion("Water is wet?");
        q2.addOption('1', "True");
        q2.addOption('2', "False");

        iVote.setQuestion(q2);

    }
}
