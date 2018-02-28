package com.zlikun.jee.handler;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 11:32
 */
public class HelloHandler extends AbstractHandler {

    private String name ;

    public HelloHandler() {
        this("World") ;
    }

    public HelloHandler(String name) {
        this.name = name;
    }

    @Override
    public void handle(String s, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");
        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);
        // Write back response
        response.getWriter().println("<h1>Hello " + this.name + "</h1>");
        // Inform jetty that this request has now been handled
        baseRequest.setHandled(true);
    }

}
