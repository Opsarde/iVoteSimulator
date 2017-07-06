package iVoteSimulator;

public class SingleChoiceQuestion implements Question {

    private String words;
    private int TYPE = 1;

    public SingleChoiceQuestion(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Single Choice Question: " + words;
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
