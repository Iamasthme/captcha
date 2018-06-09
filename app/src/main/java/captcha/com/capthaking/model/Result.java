package captcha.com.capthaking.model;

import java.io.Serializable;

public class Result implements Serializable{

    int time;
    int timetaken;
    boolean isCorrect;
    String answer;
    String oringalAnswer;

    public String getOringalAnswer() {
        return oringalAnswer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTimetaken() {
        return timetaken;
    }

    public void setTimetaken(int timetaken) {
        this.timetaken = timetaken;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setOringalAnswer(String oringalAnswer) {
        this.oringalAnswer = oringalAnswer;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
