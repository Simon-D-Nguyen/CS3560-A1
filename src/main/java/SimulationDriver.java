import java.util.*;

public class SimulationDriver {

    public static void main(String[] args) {

        System.out.println("CS3560 - Assignment 1");
        System.out.println("Author: Simon Nguyen");


        Random random = new Random(); //Add for the random number generator

        // Create Question
        System.out.println("--- Single-Choice Question ---");
        Question q1 = new SingleChoiceQuestion("Water is wet?");
        q1.addOption('1', "True");
        q1.addOption('2', "False");


        // Configure Voting Service
        VotingService iVote = new VotingService();
        iVote.setQuestion(q1);


        //Create Student IDs (randomly)
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(random.nextInt(1000));
        }

        //Create Student Answers (randomly)
        List<Character> options = iVote.getOptions().stream().toList();
        Character[] studentAnswers = new Character[students.length];

        for (int i = 0; i < studentAnswers.length; i++) {
            int choice = random.nextInt(options.size());
            studentAnswers[i] = options.get(choice);
        }

        //Submit answers
        for (int i = 0; i < studentAnswers.length; i++) {
            iVote.submitAnswer(students[i], new HashSet<>(Arrays.asList(studentAnswers[i])));
        }

        //Voting service output
        iVote.outputStatistics();
        iVote.outputStudentAnswers();








        // Create Question
        System.out.println("--- Multiple-Choice Question ---");
        Question q2 = new MultipleChoiceQuestion("Which is best?");
        q2.addOption('A', "White Bread");
        q2.addOption('B', "Sourdough");
        q2.addOption('C', "Whole Wheat");
        q2.addOption('D', "Multi-grain");



        //Configure Voting Service
        iVote.setQuestion(q2);


        // Using same students as above ...
        //Create Student answers
        List<Character> multipleChoiceOptions = iVote.getOptions().stream().toList();
        List<Set<Character>> studentMultipleChoiceAnswers = new ArrayList<>(students.length);

        for (int k = 0; k < students.length; k++) {
            int numberOfAnswers = random.nextInt(multipleChoiceOptions.size() - 1) + 1;
            Set<Character> studentAnswer = new HashSet<>();

            for (int j = 0; j <= numberOfAnswers; j++) {
                int randomOptionIndex = random.nextInt(multipleChoiceOptions.size());

                studentAnswer.add(multipleChoiceOptions.get(randomOptionIndex));
            }

            studentMultipleChoiceAnswers.add(k, studentAnswer);
        }

        //Submit answers
        for (int i = 0; i < studentAnswers.length; i++) {
            iVote.submitAnswer(students[i], studentMultipleChoiceAnswers.get(i));
        }

        //Voting service output
        iVote.outputStatistics();
        iVote.outputStudentAnswers();
    }
}
