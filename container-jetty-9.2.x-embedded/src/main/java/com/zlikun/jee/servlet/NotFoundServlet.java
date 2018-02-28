package com.zlikun.jee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/4/25 11:43
 */
public class NotFoundServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.sendError(HttpServletResponse.SC_NOT_FOUND ,"access page is not found !");
    }
}

