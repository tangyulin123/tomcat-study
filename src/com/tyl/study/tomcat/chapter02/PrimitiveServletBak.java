package com.tyl.study.tomcat.chapter02;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description
 * @Author tyl
 * @CreateDate 2020/11/15
 */
public class PrimitiveServletBak implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter out = response.getWriter();
        out.println("HTTP/1.1 200 OK");
        out.println();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>error</TITLE>");
        out.println("<meta http-equiv=\"refresh\" charset='utf-8' content=\"3>");
        out.println("</HEAD>");
        out.println("  <BODY>");
        out.print("<div align=\"center\">");
        out.print("</div>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.println("Hello. Roses are red.");
        out.print("Violets are blue.");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
