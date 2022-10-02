import com.questquestiongame.QuestionsServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuestionsServletTest {
    public QuestionsServlet questionsServlet;
    public HttpServletRequest request;
    public HttpServletResponse response;
    public ServletContext servletContext;
    public RequestDispatcher requestDispatcher;
    public HttpSession currentSession;

    @BeforeEach
    public void init(){
        questionsServlet = new QuestionsServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        servletContext = mock(ServletContext.class);
        lenient().when(request.getServletContext()).thenReturn(servletContext);
        requestDispatcher = mock(RequestDispatcher.class);
        currentSession = mock(HttpSession.class);
        lenient().when(request.getSession(true)).thenReturn(currentSession);
        lenient().when(servletContext.getRequestDispatcher("/gamesview/youlose.jsp")).thenReturn(requestDispatcher);
    }

    @ParameterizedTest
    @CsvSource({
            "question1, FormWithLeftBranchQuestionResponse, /gamesview/question2.jsp",
            "question1, FormWithRightBranchQuestionResponse, /gamesview/youlose.jsp",
            "question2, FormWithLeftBranchQuestionResponse, /gamesview/question3.jsp",
            "question2, FormWithRightBranchQuestionResponse, /gamesview/youlose.jsp",
            "question3, FormWithLeftBranchQuestionResponse, /gamesview/youwin.jsp",
            "question3, FormWithRightBranchQuestionResponse, /gamesview/youlose.jsp",
    })
    public void solveQuestionTest(String formNameQuestion, String questionResponseBranch, String pathToJSP) throws ServletException, IOException {
        lenient().when(servletContext.getRequestDispatcher(pathToJSP)).thenReturn(requestDispatcher);
        when(request.getParameter("choice")).thenReturn(questionResponseBranch);
        Assertions.assertEquals(formNameQuestion + questionResponseBranch, questionsServlet.solveQuestion(formNameQuestion,request,response, pathToJSP));
    }

    @ParameterizedTest
    @CsvSource({
            "prologue, FormWithoutQuestionResponseBranch, /gamesview/question1.jsp",
            "question1, FormWithLeftBranchQuestionResponse, /gamesview/question2.jsp",
            "question1, FormWithRightBranchQuestionResponse, /gamesview/youlose.jsp",
            "question2, FormWithLeftBranchQuestionResponse, /gamesview/question3.jsp",
            "question2, FormWithRightBranchQuestionResponse, /gamesview/youlose.jsp",
            "question3, FormWithLeftBranchQuestionResponse, /gamesview/youwin.jsp",
            "question3, FormWithRightBranchQuestionResponse, /gamesview/youlose.jsp",
            "endgame, FormWithoutQuestionResponseBranch, /gamesview/prologue.jsp",
            "none, FormWithoutBranch, noneJSP",
    })
    public void forwardPageTest(String formName, String questionResponseBranch, String pathToJSP) throws ServletException, IOException {
        when(request.getParameter("formname")).thenReturn(formName);
        lenient().when(request.getParameter("username")).thenReturn("");
        lenient().when(servletContext.getRequestDispatcher(pathToJSP)).thenReturn(requestDispatcher);
        lenient().when(request.getParameter("choice")).thenReturn(questionResponseBranch);
        Assertions.assertEquals(formName + questionResponseBranch, questionsServlet.forwardPage(request,response));
    }
}
