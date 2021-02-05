package dev.abrus.http_connector.interfaces;

public interface HttpTaskListener<R> {

    R doInBackground();

    void onPreExecute(R result);
}
