package org.estudo.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleCounter extends HttpServlet {
    int count = 0;

    @Override
    public void init() throws ServletException {
        String initialCounter = getInitParameter("InitialCounter");
        try {
            count = Integer.parseInt(initialCounter);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            count = 0;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/plain");
        try (PrintWriter writer = resp.getWriter()) {
            ++count;
            writer.println("Counter value: " + count);
        } catch (IOException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }
}
