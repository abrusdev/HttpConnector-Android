package dev.abrus.http_connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import dev.abrus.http_connector.enums.HttpMethod;

abstract class BaseHttpConnector {

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


}
