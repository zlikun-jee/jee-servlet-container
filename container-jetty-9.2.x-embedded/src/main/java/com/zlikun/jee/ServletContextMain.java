package com.zlikun.jee;

import com.zlikun.jee.servlet.HelloServlet;
import com.zlikun.jee.servlet.NotFoundServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 11:40
 */
public class ServletContextMain {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);
        context.setContextPath("/");
//        context.setResourceBase(System.getProperty("java.io.tmpdir"));
        server.setHandler(context);

        // http://localhost:8080/
        // http://localhost:8080/hello

        // Add dump servlet
        context.addServlet(HelloServlet.class, "/hello/*");
        // Add default servlet
//        context.addServlet(DefaultServlet.class, "/");
        // 访问不存在的URI时，实际将由NotFoundServlet来处理响应(404)
        context.addServlet(NotFoundServlet.class, "/");

        server.start();
        server.join();

    }

}
