package iVoteSimulator;

/**
 * The Question interface.  It can have two types
 * of question.
 */
public interface Question {
    public int getType();
    public void setQuestion(String words);
    public String toString();
}
