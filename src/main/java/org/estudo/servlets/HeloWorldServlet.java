package org.estudo.servlets;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class HeloWorldServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Method doGet is executing .....");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/json");

        if(req.getMethod().equals("HEAD"))
            return;
        JSONObject responseJson = new JSONObject();
        responseJson.put("message", "Hello World " + req.getParameter("name"));
        out.println(responseJson);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Method doPost is executing and calling doGet");
        this.doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Method service is executing .....");
        super.service(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "This servlet just get the name of the user and print it";
    }
}
