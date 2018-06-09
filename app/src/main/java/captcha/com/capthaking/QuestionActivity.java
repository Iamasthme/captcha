package captcha.com.capthaking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import captcha.com.capthaking.json.JsonParser;
import captcha.com.capthaking.model.Answer;
import captcha.com.capthaking.model.Question;
import captcha.com.capthaking.model.Result;

public class QuestionActivity extends AppCompatActivity {
    Answer mAnswer= new Answer();
    ArrayList<Question> mQuestions;
    ArrayList<Result> mResults= new ArrayList<>(5);
    TextView title,timer;
    ImageView mImageView;
    EditText mEditText;
    Button submit;
    Question question;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
         title = (TextView)findViewById(R.id.title);
         timer = (TextView)findViewById(R.id.timer);
         mImageView= findViewById(R.id.imageView);
         mEditText=findViewById(R.id.editText);
         submit= findViewById(R.id.button);

         submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {




                 Result result = new Result();
                 result.setTime(question.getTime());
                 result.setAnswer(mEditText.getText().toString());
                 result.setOringalAnswer(question.getName());
                 updateBasedonAnswer(question.getDifficulty(),question.getAnswer());
                 if (mEditText.getText().toString().equals(question.getAnswer()))
                 {
                     result.setCorrect(true);
                     mAnswer.getNextQuestionForCorrectAnswer();
                     question = getQuestionBasedonDifficlut(mAnswer.mDifficlutylevel);
                     updateUI();
                 }
                 else
                 {   mAnswer.getNextQuestionForWrongAnswer();
                     question = getQuestionBasedonDifficlut(mAnswer.mDifficlutylevel);


                 }

                 mResults.add(result);
                 if (mResults.size()==5 && mAnswer.isNextQuestionNotAvailble() )
                 {
                     Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                     intent.putExtra("results",mResults);
                     startActivity(intent);
                     return;


                 }
                 updateUI();

             }
         });

      mQuestions = JsonParser.loadJSONFromAsset(this);

        initView();


}

void initView()
{

       mAnswer.getfirstQuestion();
       question = getQuestionBasedonDifficlut(mAnswer.mDifficlutylevel);
       updateUI();


}

void updateUI(){

    title.setText("Round "+mResults.size()+1 +"/5");
  //  timer.setText(question.getTime());
    int id = getResources().getIdentifier(question.getName(), "drawable", getPackageName());
   mImageView.setImageResource(id);
    mEditText.setText("");
}



  protected Question getQuestionBasedonDifficlut(int diffi)
  {

      for (Question ques:mQuestions) {
          if (ques.getDifficulty()==diffi && !ques.isAnswered())
              return ques;

      }
  return  null;
  }

   protected void updateBasedonAnswer(int diffi, String name)


    {

        for (int i = 0; i < mQuestions.size() ; i++) {
            if (mQuestions.get(i).getDifficulty()==diffi && mQuestions.get(i).getAnswer().equals(name))
            {
                mQuestions.get(i).setAnswered(true);
            }

        }

    }
}

