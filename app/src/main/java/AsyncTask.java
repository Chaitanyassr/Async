package com.example.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AsyncTask extends android.os.AsyncTask<Void, Integer, String>{
    ProgressDialog pd;
    Context ctx;

    public AsyncTask(Context ct) { ctx=ct;}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(ctx);
        pd.setTitle("Counter Start");
        pd.setMessage("download");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "cancel", (DialogInterface.OnClickListener) -> {
            dialogInterface.cancel;
        });
        pd.Show();

    }
    @Override
    protected  String doInBackground(Void... voids) {
        try {
            for (int i = 1; i <= 100; i++) {
                Thread.sleep(1000);
                publishProgress(i);
                Log.i("Update", "Thread" + i);
            }
            catch(Exception e){
                Log.i("Exception",e.getMessage());

            }
            return "Failure";

        }
    @Override
            protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            int myVal=values[0];
            pd.setProgress(myVal);
        }
    @Override
        protected void onPostExecute(String s) {
            super.onPreExecute(s);
            Toast.makeText(ctx,s,Toast.LENGTH_LONG.show());
            pd.dismiss();

    }


    }
}