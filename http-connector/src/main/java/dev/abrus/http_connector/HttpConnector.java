package dev.abrus.http_connector;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import dev.abrus.http_connector.enums.HttpMethod;
import dev.abrus.http_connector.interfaces.HttpParams;

public class HttpConnector extends BaseHttpConnector implements HttpParams {

    private URL url;
    private final String TAG = "HttpConnector";

    private HttpConnector(URL url) throws IOException {
        conn = (HttpURLConnection) url.openConnection();
        setRequestMethod(method);
    }

    public static HttpConnector create(String link) throws IOException {
        URL url = new URL(link);
        return new HttpConnector(url);
    }

    public static HttpConnector create(URL url) throws IOException {
        return new HttpConnector(url);
    }

    public void log(String TAG) throws IOException {
        initBufferedReader();
        String line;
        while ((line = buffer.readLine()) != null)
            Log.i(TAG, line);
    }

    public void log() throws IOException {
        log(TAG);
    }

    @Override
    public HttpConnector setMethod(HttpMethod method) throws IOException {
        setRequestMethod(method);
        return this;
    }

    @Override
    public HttpConnector setDoInput(boolean doInput) {
        conn.setDoInput(true);
        return this;
    }

    @Override
    public HttpConnector setDoOutput(boolean doOutput) {
        conn.setDoOutput(true);
        return this;
    }
}
