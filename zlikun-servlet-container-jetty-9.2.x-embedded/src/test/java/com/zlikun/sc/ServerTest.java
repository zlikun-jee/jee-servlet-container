package com.zlikun.sc;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * 以内嵌方式运行Jetty服务
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 10:11
 */
public class ServerTest {

    @Test @Ignore
    public void start() throws Exception {

        Server server = new Server(8080) ;
        server.setHandler(new AbstractHandler() {
            @Override
            public void handle(String s, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                // Declare response encoding and types
                response.setContentType("text/html; charset=utf-8");

                // Declare response status code
                response.setStatus(HttpServletResponse.SC_OK);

                // Write back response
                response.getWriter().println("<h1>Hello World</h1>");

                // Inform jetty that this request has now been handled
                baseRequest.setHandled(true);
            }
        });

        server.start();
        server.join();

    }

}