package com.zlikun.jee;

import com.zlikun.jee.handler.HelloHandler;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

/**
 * Many contexts
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 11:35
 */
public class ManyContextsMain {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        // http://localhost:8080/
        ContextHandler context = new ContextHandler("/");
        context.setContextPath("/");
        context.setHandler(new HelloHandler("Root Hello"));

        // http://localhost:8080/fr
        ContextHandler contextFR = new ContextHandler("/fr");
        contextFR.setHandler(new HelloHandler("Bonjoir"));

        // http://localhost:8080/it
        ContextHandler contextIT = new ContextHandler("/it");
        contextIT.setHandler(new HelloHandler("Bongiorno"));

        // http://127.0.0.1:8080/
        ContextHandler contextV = new ContextHandler("/");
        contextV.setVirtualHosts(new String[] { "127.0.0.1" });
        contextV.setHandler(new HelloHandler("Virtual Hello"));

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { context, contextFR, contextIT, contextV });

        server.setHandler(contexts);

        server.start();
        server.join();

    }

}
