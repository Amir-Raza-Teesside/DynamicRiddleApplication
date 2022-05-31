package uk.ac.tees.aad.triviaapp;

public class QuestionModel {

    private  String Question;
    private String Answer;
    private String OptionA;
    private String OptionC;
    private String OptionB;

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String optionA) {
        OptionA = optionA;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setOptionC(String optionC) {
        OptionC = optionC;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String optionB) {
        OptionB = optionB;
    }



    public QuestionModel() {

    }



    public QuestionModel(String question, String answer, String optionA, String optionB, String optionC) {
        Question = question;
        Answer = answer;
        OptionA = optionA;
        OptionB = optionB;
        OptionC = optionC;
    }



}
