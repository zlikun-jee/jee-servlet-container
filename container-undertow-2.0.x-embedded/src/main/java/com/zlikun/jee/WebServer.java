package com.zlikun.jee;

import io.undertow.Undertow;
import io.undertow.util.Headers;

/**
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-02-28 11:19
 */
public class WebServer {

    public static void main(final String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(exchange -> {
                    exchange.getResponseHeaders()
                            .put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender()
                            .send("Hello World");
                }).build();
        server.start();
    }

}
