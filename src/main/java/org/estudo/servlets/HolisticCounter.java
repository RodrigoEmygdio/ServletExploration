package org.estudo.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HolisticCounter extends HttpServlet {
    static int classCount = 0;
    int count = 0;
    static Map<HolisticCounter,HolisticCounter> instance = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            count++;
            writer.println("Since loading, this servlet instance has been accessed " + count + " times.");
            instance.put(this, this);
            synchronized (this) {
                classCount++;
            }
            writer.println("There are currently " + instance.size() + " instances.");
            writer.println("Across all instances, this servlet class has been " + " accessed " + classCount + " times");
        } catch (IOException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
