package dev.abrus.httpconnector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executors;

import dev.abrus.http_connector.ConnectorUrl;
import dev.abrus.http_connector.HttpConnector;
import dev.abrus.http_connector.interfaces.HttpTaskListener;
import dev.abrus.http_connector.methods.HttpMethod;
import dev.abrus.http_connector.task.HttpAsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        HttpConnector.create(BASE_URL)
//                .setConnectTimeout(10000)
//                .setReadTimeout(10000)
//                .setMethod(HttpMethod.POST)
//                .setDoInput(true)
//                .setDoOutput(true)
//                .setQuery("login", "login")
//                .setQuery("pass", "pass")
//                .getBuffer();
    }
}