package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;



public class SimpleAsyncTask extends AsyncTask<Void,Void,String> {
    private WeakReference<TextView> mTextView;
    SimpleAsyncTask(TextView tv) {
         mTextView = new WeakReference<>(tv);

    }
    @Override
    protected String doInBackground(Void... voids){
        // generate random number btw 0-10
        Random r = new Random();
        int n=r.nextInt(11);
        //make task take long enough so can have
        //time to rotate phone while its running
        int s = n*200;
       //sleep random amt time

        try{
            Thread.sleep(s);

        }catch (InterruptedException e){
            e.printStackTrace();
        }


        return  "Awake at last after sleeping for " + s +"milliseconds";
    }

    protected void onPostExecute(String result){
        mTextView.get().setText(result);
    }
}
