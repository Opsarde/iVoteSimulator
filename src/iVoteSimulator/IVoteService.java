package iVoteSimulator;

import java.util.ArrayList;
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
    private int[] Totalcounts;
    private Map<String, List<Boolean>> students;

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
        int choiceCount = 0;
        for (Boolean b : choice) {
            if (b)
                choiceCount++;
        }
        
        if (students.containsKey(student.getID())) {
            //replace previous answer submitted
            students.replace(student.getID(), choice);
        }
        
        if (question.getType() == 1 && choiceCount > 1) {
            //student can only select one choice for SingleChoiceQuestion
        }

    }
    
    /**
     * getChoice:
     * @return Possible choice to student.
     */
    public List<Boolean> getChoice() {
        //return answers;
        return new ArrayList<Boolean>(answers.size());
    }
    
    /**
     * getAnswer:
     * @return viewable answers to student.
     */
    public List<String> getAnswer() {
        return answers;
    }

    public void printResult() {
        // Show total number of submits for each answer
        // An answer is configured in Service /or in Question
    }
}
