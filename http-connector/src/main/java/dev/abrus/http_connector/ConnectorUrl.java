package dev.abrus.http_connector;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URLEncoder;

public class ConnectorUrl {

    StringBuilder baseURL;
    boolean isFirst = true;

    private ConnectorUrl(String url) {
        baseURL = new StringBuilder();
        baseURL.append(url);
    }

    public static ConnectorUrl create(String baseURL) {
        return new ConnectorUrl(baseURL);
    }

    public ConnectorUrl setAction(String action) {
        if (action.startsWith("http")) {
            baseURL = new StringBuilder();
        }
        baseURL.append(action);
        return this;
    }

    public ConnectorUrl setQuery(String key, String value) throws IOException {
        if (isFirst) {
            isFirst = false;
            baseURL.append("?");
        } else baseURL.append("&");

        baseURL.append(URLEncoder.encode(key, "UTF-8"));
        baseURL.append("=");
        baseURL.append(URLEncoder.encode(value, "UTF-8"));
        return this;
    }

    public String get() {
        return baseURL.toString();
    }

    @NotNull
    @Override
    public String toString() {
        return baseURL.toString();
    }
}
