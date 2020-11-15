package com.tyl.study.tomcat.chapter02;

import com.tyl.study.tomcat.util.Constants;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @Description 该类处理servlet请求
 * @Author tyl
 * @CreateDate 2020/11/15
 */
public class ServletProcessor1 {


    public void process(Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);
            // the forming of repository is taken from the
            // createClassLoader method in
            // org.apache.catalina.startup.ClassLoaderFactory
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
            // the code for forming the URL is taken from
            // the addRepository method in
            // org.apache.catalina.loader.StandardClassLoader.
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //加载类
        Class myClass = null;
        Servlet servlet = null;
        try {
            myClass = loader.loadClass(servletName);
            servlet = (Servlet) myClass.newInstance();
            servlet.service(request,response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
            System.out.println(e.toString());
        }

    }
}
