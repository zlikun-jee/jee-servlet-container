package com.zlikun.jee;

import com.zlikun.jee.handler.HelloHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

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
