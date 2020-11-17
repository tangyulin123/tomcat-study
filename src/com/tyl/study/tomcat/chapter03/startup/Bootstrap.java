package com.tyl.study.tomcat.chapter03.startup;

import com.tyl.study.tomcat.chapter03.connector.http.HttpConnector;

/**
 * @Description 启动类
 * @Author tyl
 * @CreateDate 2020/11/17
 */
public class Bootstrap {

    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
