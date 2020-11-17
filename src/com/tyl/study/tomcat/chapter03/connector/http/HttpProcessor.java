package com.tyl.study.tomcat.chapter03.connector.http;

import java.net.Socket;

/**
 * @Description
 * @Author tyl
 * @CreateDate 2020/11/17
 */
public class HttpProcessor {

    private HttpConnector httpConnector = null;

    public HttpProcessor(HttpConnector httpConnector) {
        this.httpConnector = httpConnector;
    }

    public void process(Socket socket) {

        try {


        } catch (Exception e) {

        }
    }
}
