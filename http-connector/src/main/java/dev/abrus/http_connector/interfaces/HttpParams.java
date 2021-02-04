package dev.abrus.http_connector.interfaces;

import java.io.IOException;

import dev.abrus.http_connector.HttpConnector;
import dev.abrus.http_connector.enums.HttpMethod;

public interface HttpParams {

    HttpConnector setMethod(HttpMethod method) throws IOException;

    HttpConnector setDoInput(boolean doInput);

    HttpConnector setDoOutput(boolean doOutput);
}
