package com.questquestiongame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "QuestionsServlet", value = "/questions")
public class QuestionsServlet extends HttpServlet implements PageForwardable {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardPage(req, resp);
    }

    @Override
    public String forwardPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formname = req.getParameter("formname");
        HttpSession currentSession = req.getSession(true);

        if (formname.equals("prologue")) {
            String username = req.getParameter("username");
            currentSession.setAttribute("username", username);
            req.getServletContext().getRequestDispatcher("/gamesview/question1.jsp").forward(req, resp);
            return "prologueFormWithoutQuestionResponseBranch";
        }

        if (formname.equals("question1")) {
            return solveQuestion(formname, req, resp, "/gamesview/question2.jsp");
        }

        if (formname.equals("question2")) {
            return solveQuestion(formname, req, resp, "/gamesview/question3.jsp");
        }

        if (formname.equals("question3")) {
            return solveQuestion(formname, req, resp, "/gamesview/youwin.jsp");
        }

        if (formname.equals("endgame")) {
            req.getServletContext().getRequestDispatcher("/gamesview/prologue.jsp").forward(req, resp);
            return "endgameFormWithoutQuestionResponseBranch";
        }

        return "noneFormWithoutBranch";
    }




    public String solveQuestion(String formNameQuestion,
                                HttpServletRequest req,
                                HttpServletResponse resp,
                                String pathToJSP) throws ServletException, IOException {

        String radioButtonChoice = req.getParameter("choice");
        if (radioButtonChoice.equals("FormWithLeftBranchQuestionResponse")){
            req.getServletContext().getRequestDispatcher(pathToJSP).forward(req, resp);
            return formNameQuestion + "FormWithLeftBranchQuestionResponse";
        } else {
            req.getServletContext().getRequestDispatcher("/gamesview/youlose.jsp").forward(req, resp);
            return formNameQuestion + "FormWithRightBranchQuestionResponse";
        }
    }
}

