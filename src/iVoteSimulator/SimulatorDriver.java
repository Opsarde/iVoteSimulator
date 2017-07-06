package iVoteSimulator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * SimulatorDriver: Main class that simulates the whole
 * process of IVote.
 * 
 * @author shun
 *
 */
public class SimulatorDriver {
    
    /**
     * configureQuestionType
     * Purpose: Determine the question type for a question.
     */
    
    public static Student generateStudent() {
        Random rand = new Random();
        Student student = new Student(String.valueOf(rand.nextInt(1000000000)));
        return student;
    }

    public static IVoteService createService() {
        return new IVoteService();
    }

    /**
     * The driver hardcoded creation process. 
     */
    public static void main(String[] args) {
        Question question1 = new MultiChoiceQuestion("iVoteSimulator tester.");
        IVoteService service = createService();
        service.configureQuestion(question1);
        List<String> answers = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        service.configureAnswer(answers);
        List<Student> students = new ArrayList<>();
        // generate 40 students into the list.
        for (int i = 0; i < 40; i++) {
            students.add(generateStudent());
        }
        List<Boolean> randomChoice = service.getChoice();
        for (Student student : students) {
            service.submitAnswer(student, randomChoice);
        }
        service.printResult();
        System.out.println("Hello");
    }
}
