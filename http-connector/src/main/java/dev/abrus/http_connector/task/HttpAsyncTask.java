package dev.abrus.http_connector.task;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.abrus.http_connector.interfaces.HttpTaskListener;

public class HttpAsyncTask<R> {

    ExecutorService service;
    Handler handler;

    public HttpAsyncTask() {
        service = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public HttpAsyncTask<R> setHandler(Handler handler) {
        this.handler = handler;
        return this;
    }

    public HttpAsyncTask<R> setLooper(Looper looper) {
        this.handler = new Handler(looper);
        return this;
    }

    public HttpAsyncTask<R> setExecutorService(ExecutorService service) {
        this.service = service;
        return this;
    }

    public void create(HttpTaskListener<R> listener) {
        service.execute(() -> {
            R result = listener.doInBackground();

            handler.post(() -> listener.onPreExecute(result));
        });
    }
}
