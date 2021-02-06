package dev.abrus.http_connector;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import dev.abrus.http_connector.methods.HttpMethod;
import dev.abrus.http_connector.interfaces.HttpParams;

public class HttpConnector extends BaseHttpConnector implements HttpParams {

    private static final int DEFAULT_TIMEOUT = 10000;
    private static final String TAG = "HttpConnector";

    private HashMap<String, String> query;

    private HttpConnector(URL url) throws IOException {
        query = new HashMap<>();

        conn = (HttpURLConnection) url.openConnection();
        setRequestMethod(method);
        this.setConnectTimeout(DEFAULT_TIMEOUT);
        this.setReadTimeout(DEFAULT_TIMEOUT);
    }

    public static HttpConnector create(String link) throws IOException {
        URL url = new URL(link);
        return new HttpConnector(url);
    }

    public static HttpConnector create(URL url) throws IOException {
        return new HttpConnector(url);
    }

    public void log(String TAG) throws IOException {
        initOutputStream(query);
        initBufferedReader();
        String line;
        while ((line = buffer.readLine()) != null)
            Log.i(TAG, line);
    }

    public void log() throws IOException {
        log(TAG);
    }

    public String get() throws IOException {
        initOutputStream(query);
        initBufferedReader();
        return html.toString();
    }

    public BufferedReader getBuffer() throws IOException {
        initOutputStream(query);
        initBufferedReader();
        return buffer;
    }

    public Document getDocument() throws IOException {
        initOutputStream(query);
        initBufferedReader();
        return Jsoup.parse(html.toString());
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

    @Override
    public HttpConnector setConnectTimeout(int time) {
        conn.setConnectTimeout(time);
        return this;
    }

    @Override
    public HttpConnector setReadTimeout(int time) {
        conn.setReadTimeout(time);
        return this;
    }

    @Override
    public HttpConnector setQuery(String key, String value) {
        query.put(key, value);
        return this;
    }
}
