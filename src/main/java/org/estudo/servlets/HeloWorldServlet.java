package org.estudo.servlets;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class HeloWorldServlet extends HttpServlet {

    static  Logger logger = Logger.getLogger(HeloWorldServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Method doGet is executing .....");

        try (PrintWriter out = resp.getWriter()) {
            resp.setContentType("text/json");

            if (req.getMethod().equals("HEAD"))
                return;
            JSONObject responseJson = new JSONObject();
            responseJson.put("message", "Hello World " + req.getParameter("name"));
            out.println(responseJson);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Method doPost is executing and calling doGet");
        try {
            this.doGet(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
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
