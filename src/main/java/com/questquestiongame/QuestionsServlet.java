package com.questquestiongame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "QuestionsServlet", value = "/questions")
public class QuestionsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formname = req.getParameter("formname");
        HttpSession currentSession = req.getSession(true);

        if (formname.equals("prologue")) {
            String username = req.getParameter("username");
            currentSession.setAttribute("username", username);
            req.getServletContext().getRequestDispatcher("/gamesview/question1.jsp").forward(req, resp);
        }

        if (formname.equals("question1")) {
            String radioButtonChoice = req.getParameter("choice");
            if (radioButtonChoice.equals("leftBranch")){
                req.getServletContext().getRequestDispatcher("/gamesview/question2.jsp").forward(req, resp);
            } else {
                req.getServletContext().getRequestDispatcher("/gamesview/youlose.jsp").forward(req, resp);
            }
        }

        if (formname.equals("question2")) {
            String radioButtonChoice = req.getParameter("choice");
            if (radioButtonChoice.equals("leftBranch")){
                req.getServletContext().getRequestDispatcher("/gamesview/question3.jsp").forward(req, resp);
            } else {
                req.getServletContext().getRequestDispatcher("/gamesview/youlose.jsp").forward(req, resp);
            }
        }

        if (formname.equals("question3")) {
            String radioButtonChoice = req.getParameter("choice");
            if (radioButtonChoice.equals("leftBranch")){
                req.getServletContext().getRequestDispatcher("/gamesview/youwin.jsp").forward(req, resp);
            } else {
                req.getServletContext().getRequestDispatcher("/gamesview/youlose.jsp").forward(req, resp);
            }
        }

        if (formname.equals("endgame")) {
                req.getServletContext().getRequestDispatcher("/gamesview/prologue.jsp").forward(req, resp);
        }
    }
}

