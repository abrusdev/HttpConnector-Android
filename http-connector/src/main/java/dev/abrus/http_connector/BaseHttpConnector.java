package dev.abrus.http_connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import dev.abrus.http_connector.methods.HttpMethod;

abstract class BaseHttpConnector {

    StringBuilder html;

    HttpMethod method = HttpMethod.GET;
    BufferedReader buffer;

    protected HttpURLConnection conn;

    protected void setRequestMethod(HttpMethod method) throws IOException {
        switch (method) {
            case GET:
                conn.setRequestMethod("GET");
                break;
            case POST:
                conn.setRequestMethod("POST");
                break;
        }
    }

    protected void initBufferedReader() throws IOException {
        buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    }

    protected void initOutputStream(HashMap<String, String> query) throws IOException {
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.write(getPostDataString(query));

        writer.flush();
        writer.close();
        os.close();
    }

    protected void readAllLines() throws IOException {
        html = new StringBuilder();
        String line;
        while ((line = buffer.readLine()) != null) {
            html.append(line.trim()).append('\n');
        }
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

}
