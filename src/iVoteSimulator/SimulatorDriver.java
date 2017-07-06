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
        Random rand = new Random();
        //SimulatorDriver driver = new SimulatorDriver();
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
        List<Boolean> choices;
        System.out.println(service.getAnswer());
        for (Student student : students) {
            choices = service.getChoice();
            System.out.println("why" + choices.size());
            
            // Random each choice
            for (int i = 0; i < choices.size(); i++) {
                choices.set(i, rand.nextBoolean());
            }
            service.submitAnswer(student, choices);
        }
        service.printResult();
        System.out.println("Hello");
    }
}