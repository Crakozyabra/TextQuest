package com.questquestiongame;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PageForwardable {
    public String forwardPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
