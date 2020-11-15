package com.tyl.study.tomcat.chapter01;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description request负责转换数据
 * @Author tyl
 * @CreateDate 2020/11/15
 */
public class Request {
    private InputStream inputStream;
    private String uri;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getUri() {
        return uri;
    }

    public void parse() {
        StringBuffer stringBuffer = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            stringBuffer.append((char) buffer[j]);
        }
        System.out.println(stringBuffer.toString());
        uri = parseUri(stringBuffer.toString());
    }

    private String parseUri(String toString) {
        int index1, index2;
        //这里的功能是截取http协议中的uri:GET /index.html HTTP/1.1
        index1 = toString.indexOf(" ");
        if (index1 != -1) {
            index2 = toString.indexOf(" ", index1 + 1);
            if (index2 > index1) {
                return toString.substring(index1 + 1, index2);
            }
        }
        return null;
    }

}
