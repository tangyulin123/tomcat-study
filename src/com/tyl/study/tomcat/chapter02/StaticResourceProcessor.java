package com.tyl.study.tomcat.chapter02;

import java.io.IOException;

/**
 * @Description
 * @Author tyl
 * @CreateDate 2020/11/15
 */
public class StaticResourceProcessor {

    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
