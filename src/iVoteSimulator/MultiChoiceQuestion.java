package iVoteSimulator;

public class MultiChoiceQuestion implements Question {

    private String words;
    private final int TYPE = 0;
    
    public MultiChoiceQuestion(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Multiple Choice Question: " + words;
    }

    @Override
    public int getType() {
        return TYPE;
    }

    @Override
    public void setQuestion(String words) {
        this.words = words;
    }

}
