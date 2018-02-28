package com.zlikun.jee;

import com.zlikun.sc.handler.HelloHandler;
import org.eclipse.jetty.server.Server;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 以内嵌方式运行Jetty服务
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 10:11
 */
public class ServerTest {

    @Test @Ignore
    public void start() throws Exception {

        Server server = new Server(8080) ;
        server.setHandler(new HelloHandler());

        server.start();
        server.join();

    }

}