package iVoteSimulator;

public class Student implements IStudent{

    private final String studentID;

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public String getID() {
        return studentID;
    }
}
