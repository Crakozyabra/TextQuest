import com.questquestiongame.PrologueServlet;
import org.junit.jupiter.api.Assertions;
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
import java.lang.reflect.InvocationTargetException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PrologueServletTest {


    @ParameterizedTest
    @CsvSource({
            "leftBranch, /gamesview/prologue.jsp, endgameFormLeftBranch",
            "rightBranch, /gamesview/question1.jsp, endgameFormRightBranch"
    })
    public void forwardPageTest(String questionResponseBranchDirection,
                                String pathToJSP,
                                String functionExceptReturn) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ServletException, IOException {
        PrologueServlet prologueServlet = new PrologueServlet();
        Integer gamesQuanity = 0;
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletContext servletContext = mock(ServletContext.class);
        HttpSession currentSession = mock(HttpSession.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        when(request.getSession(true)).thenReturn(currentSession);
        when(request.getParameter("formname")).thenReturn("endgame");
        when(request.getParameter("choice")).thenReturn(questionResponseBranchDirection);
        lenient().when(currentSession.getAttribute("gamesquanity")).thenReturn(gamesQuanity);
        when(request.getServletContext()).thenReturn(servletContext);
        when(request.getServletContext().getRequestDispatcher(pathToJSP)).thenReturn(requestDispatcher);
        Assertions.assertEquals(functionExceptReturn, prologueServlet.forwardPage(request,response));
        prologueServlet.forwardPage(request,response);
    }

}
