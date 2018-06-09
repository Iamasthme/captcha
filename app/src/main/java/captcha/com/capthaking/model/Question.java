package captcha.com.capthaking.model;

import java.io.Serializable;

public class Question implements Serializable{

    int id;
    String name;
    int difficulty;
    String  answer;
    boolean isAnswered=false;
    int time;

    public boolean isAnswered() {
        return isAnswered;
    }

    public int  getTime()
    {
        switch (difficulty)
        {
            case 1: time=10;
            break;
            case 2: time=15;
            break;
            case 3 : time=20;
            break;
            case  4: time=25;
            break;
            case 5:time=30;
            break;

        }
        return time;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
