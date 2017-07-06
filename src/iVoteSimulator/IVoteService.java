package iVoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IVoteService:
 * Accept answer from students.
 * Each service should hold one question.
 * Has basic output statistic function.
 * No additional functionality
 */
public class IVoteService {
    private Question question;
    // Answer choices will be contained inside
    // IVoteService class. 
    private List<String> answers;
    private Map<String, List<Boolean>> students;
    
    public IVoteService() {
        question = null;
        answers = new ArrayList<>();
        students = new HashMap<>();
    }

    public void configureQuestion(Question question) {
        this.question = question;
    }

    public void configureAnswer(List<String> answers) {
        this.answers = answers;
    }

    /**
     * submitAnswer:
     * Students can submit answer through this method.
     */
    public void submitAnswer(Student student, List<Boolean> choice) {
        boolean valid = checkAnswerValid(choice);
        if (valid)
            addStudentKey(student, choice);
    }
    
    /**
     * checkAnswer:
     * Verify student answer to service.
     * If the answer made by student is not valid, 
     * return false.
     */
    private boolean checkAnswerValid(List<Boolean> choice) {
        if (choice.size() != answers.size())
            return false;
        int choiceCount = 0;
        for (Boolean b : choice) {
            if (b)
                choiceCount++;
        }
        if (question.getType() == 1 && choiceCount > 1) {
            //student can only select one choice for SingleChoiceQuestion
            System.out.println("Please select only one choice.");
            return false;
        }
        return true;
    }
    
    /**
     * addStudentKey:
     * If the student exist, replace with the
     * last answer, else add the student and answer.
     */
    private void addStudentKey(Student student, List<Boolean> choice) {
        if (students.containsKey(student.getID())) {
            //replace previous answer submitted
            students.replace(student.getID(), choice);
        }
        else {
            students.put(student.getID(), choice);
        }
        
    }
    /**
     * getChoice:
     * @return Possible choice to student.
     */
    public List<Boolean> getChoice() {
        //return answers;
        System.out.println("What is size now: " + answers.size());
        return new ArrayList<Boolean>(0);
    }
    
    /**
     * getAnswer:
     * @return viewable answers to student.
     */
    public List<String> getAnswer() {
        return answers;
    }

    /**
     * printResult:
     * display the statistic.
     */
    public void printResult() {
        // Show total number of submits for each answer
        int[] totalcounts = new int[answers.size()];
        for (List<Boolean> answer : students.values()) {
            for (int i = 0; i < answer.size(); i++) {
                if (answer.get(i)) {
                    totalcounts[i]++;
                }
            }
        }
        for (int i = 0; i < totalcounts.length; i++) {
            System.out.println(answers.get(i) + ": " + totalcounts[i]);
        }
    }
}
