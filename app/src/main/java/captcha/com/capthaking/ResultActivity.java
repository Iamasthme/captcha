package captcha.com.capthaking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import captcha.com.capthaking.model.Result;

public class ResultActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    MyAdapter mMyAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ArrayList<Result> results = (ArrayList<Result>) getIntent().getExtras().getSerializable("results");

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        // specify an adapter (see also next example)
        mMyAdapter = new MyAdapter(results,this);
        mRecyclerView.setAdapter(mMyAdapter);

        TextView textView = findViewById(R.id.textView1);
        textView.setText("Score "+ getCorrectAnsewr(results)+"/5");
    }


    public  int getCorrectAnsewr(ArrayList<Result> results)
    {
        int count =0;
        for (Result result:results)
        {
            if (result.isCorrect())
                count++;

        }
        return  count;
    }



}
