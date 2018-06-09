package captcha.com.capthaking.model;

import java.io.Serializable;

public class Answer implements Serializable {

 public    int mDifficlutylevel = 3;
  public   int mTime = 20;


    public  void getNextQuestionForCorrectAnswer()
    {
        if (mDifficlutylevel!=5)
        {
            mDifficlutylevel= mDifficlutylevel+1;
            mTime= mTime+5;
        }
        else
        {
            mTime=5;
            mTime=30;
        }

    }

    public void getfirstQuestion()
    {
        mDifficlutylevel = 3;
    }

    public void getNextQuestionForWrongAnswer()
    {
        mDifficlutylevel=mDifficlutylevel-1;
        mTime= mTime-5;
    }

    public boolean isNextQuestionNotAvailble()
    {
       return  mDifficlutylevel==0 ;
    }
}
