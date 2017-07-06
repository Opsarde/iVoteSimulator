/****************************
 * CS 356 - Assignment 1
 * Shun Lu
 * June 6, 2016
 * 
 * Description: A IVote simulator that let user 
 * to configure question and let students to 
 * choose answers.
 * 
 ***************************/

package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * SimulatorDriver: Main class that simulates the whole
 * process of IVote. Like a tester class.
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
    
    public void startMultiChoice() {
        Random rand = new Random();
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
        boolean[] choices;
        for (Student student : students) {
            choices = service.getChoice();
            // Random each choice
            for (int i = 0; i < choices.length; i++) {
                choices[i] = rand.nextBoolean();
            }
            service.submitAnswer(student, choices);
        }
        service.printResult();
    }
    
    public void startSingleChoice() {
        Random rand = new Random();
        Question question1 = new SingleChoiceQuestion("iVoteSimulator tester.");
        IVoteService service = createService();
        service.configureQuestion(question1);
        List<String> answers = new ArrayList<>(Arrays.asList("1. Right", "2. Wrong"));
        service.configureAnswer(answers);
        List<Student> students = new ArrayList<>();
        // generate 40 students into the list.
        for (int i = 0; i < 40; i++) {
            students.add(generateStudent());
        }
        boolean[] choices;
        for (Student student : students) {
            choices = service.getChoice();
            // Random each choice
            choices[rand.nextInt(choices.length)] = true;
            service.submitAnswer(student, choices);
        }
        service.printResult();
        
    }

    /**
     * The driver hardcoded creation process and random generator. 
     */
    public static void main(String[] args) {
        SimulatorDriver driver = new SimulatorDriver();
        driver.startMultiChoice();
        driver.startSingleChoice();
    }
}