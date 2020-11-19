package org.estudo.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

public class HolisticCounter extends HttpServlet {
    static int classCount = 0;
    int count = 0;
    static Hashtable<HolisticCounter,HolisticCounter> instance = new Hashtable<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        count++;
        writer.println("Since loading, this servlet instance has been accessed " + count + " times.");
        instance.put(this, this);
        writer.println("There are currently " + instance.size() + " instances.");
        classCount++;
        writer.println("Across all instances, this servlet class has been " + " accessed " + classCount + " times");
    }
}
