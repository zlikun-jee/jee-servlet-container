package com.zlikun.jee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 11:23
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("<h1>Hello from HelloServlet</h1>");
    }
}
