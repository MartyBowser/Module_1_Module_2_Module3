package com.techelevator;

public class HomeworkAssignment {
    //state - variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    //Constructor
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }
    //Methods

    //getter
    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        String letterGrade = "";
        double percent = ((double) earnedMarks / possibleMarks) * 100;
        if (percent >= 90) {
            letterGrade = "A";

        } else if (percent >= 80) {
            letterGrade = "B";
        } else if (percent >= 70) {
            letterGrade = "C";

        } else if (percent >= 60) {

            letterGrade = "D";

        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }

//setters

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }
}

