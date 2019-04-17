package com.example.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Key for saving the state of the TextView
    private static final String TEXT_STATE = "currentText";
    //show result textview
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=findViewById(R.id.textView1);

        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    // @param view The view (Button) that was clicked.

    public void startTask(View view) {
        //put message in text view

        mTextView.setText(R.string.napping);
         //asynctask has callback that will update text view
        new SimpleAsyncTask(mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE,mTextView.getText().toString());
    }
}
