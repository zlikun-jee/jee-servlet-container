package com.zlikun.sc;

import com.zlikun.sc.handler.HelloHandler;
import com.zlikun.sc.servlet.HelloServlet;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Single Context
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 11:27
 */
public class ContextHandlerMain {

    public static void main(String[] args) throws Exception {

        Server server = new Server( 8080 );

        // Add a single handler on context "/hello"
        ContextHandler context = new ContextHandler();
        context.setContextPath( "/hello" );
        context.setHandler( new HelloHandler() );

        // Can be accessed using http://localhost:8080/hello
        server.setHandler( context );

        // Start the server
        server.start();
        server.join();

    }

}
