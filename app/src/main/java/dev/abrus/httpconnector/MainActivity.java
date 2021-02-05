package dev.abrus.httpconnector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executors;

import dev.abrus.http_connector.interfaces.HttpTaskListener;
import dev.abrus.http_connector.task.HttpAsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HttpAsyncTask<Integer>()
                .setHandler(new Handler(Looper.getMainLooper()))
                .setExecutorService(Executors.newSingleThreadExecutor())
                .create(new HttpTaskListener<Integer>() {
                    @Override
                    public Integer doInBackground() {
                        return null;
                    }

                    @Override
                    public void onPreExecute(Integer result) {

                    }
                });
    }
}