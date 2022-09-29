package com.questquestiongame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.Inet4Address;

@WebServlet(name = "PrologueServlet", value = "/prologue")
public class PrologueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        currentSession.setAttribute("ip", Inet4Address.getLocalHost().getHostAddress());
        currentSession.setAttribute("username", "пока не указано");
        currentSession.setAttribute("gamesquanity", 0);
        req.getServletContext().getRequestDispatcher("/gamesview/prologue.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formname = req.getParameter("formname");
        HttpSession currentSession = req.getSession(true);
        if (formname.equals("endgame")) {
            String radioButtonChoice = req.getParameter("choice");
            if (radioButtonChoice.equals("leftBranch")){
                currentSession.setAttribute("username", "пока не указано");
                currentSession.setAttribute("gamesquanity", 0);
                req.getServletContext().getRequestDispatcher("/gamesview/prologue.jsp").forward(req, resp);
            } else {
                Integer gamesQuanity = (Integer) currentSession.getAttribute("gamesquanity");
                gamesQuanity++;
                currentSession.setAttribute("gamesquanity", gamesQuanity);
                req.getServletContext().getRequestDispatcher("/gamesview/question1.jsp").forward(req, resp);
            }
        }
    }
}
