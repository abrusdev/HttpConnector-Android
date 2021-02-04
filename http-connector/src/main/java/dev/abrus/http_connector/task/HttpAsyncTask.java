package dev.abrus.http_connector.task;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.abrus.http_connector.interfaces.HttpTaskListener;

public class HttpAsyncTask {

    ExecutorService service;
    Handler handler;

    private HttpAsyncTask() {
        service = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public static HttpAsyncTask create() {
        return new HttpAsyncTask();
    }

    public HttpAsyncTask setHandler(Handler handler) {
        this.handler = handler;
        return this;
    }

    public HttpAsyncTask setLooper(Looper looper) {
        this.handler = new Handler(looper);
        return this;
    }

    public HttpAsyncTask setExecutorService(ExecutorService service) {
        this.service = service;
        return this;
    }

    public void start(HttpTaskListener listener) {
        service.execute(() -> {
            listener.doInBackground();

            handler.post(listener::onPreExecute);
        });
    }
}
