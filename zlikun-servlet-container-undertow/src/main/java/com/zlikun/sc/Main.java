package com.zlikun.sc;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.servlet.spec.HttpServletResponseImpl;
import io.undertow.util.Headers;
import io.undertow.util.Protocols;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 13:52
 */
public class Main {

    public static void main(String[] args) {

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        exchange.setProtocol(Protocols.HTTP_1_1) ;
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/html");
                        exchange.getResponseSender().send("Hello World");
                    }
                }).build();

        server.start();

    }

}
