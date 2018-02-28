package com.zlikun.jee;

import com.zlikun.jee.servlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * 处理Servlet请求
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 9:59
 */
public class ServletHandlerMain {

    public static void main(String[] args) throws Exception {

        // The Server
        Server server = new Server();
        server.setStopAtShutdown(true);
        server.setSessionIdManager(new HashSessionIdManager());

        // HTTP connector
        ServerConnector http = new ServerConnector(server);
        http.setHost("localhost");
        http.setPort(8080);
        http.setStopTimeout(30000);
        http.setIdleTimeout(30000);
        server.addConnector(http);

        // Set a handler
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(HelloServlet.class, "/*");

        server.dumpStdErr();

        // Start the server
        server.start();
        server.join();

    }

}
