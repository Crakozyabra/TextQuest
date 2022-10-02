<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="upperPagePath.jsp"%>
<h2>Ты принял вызов. Поднимешься на костик к капитану?</h2>
<form method="post" action="\questions">
    <input type="hidden" name="formname" value="question2"/>
    <div class="padding-inside">
        <div>
            <input type="radio" id="choice1" name="choice" value="FormWithLeftBranchQuestionResponse" checked>
            <label for="choice1">Подняться на мостик</label>
        </div>

        <div>
            <input type="radio" id="choice2" name="choice" value="FormWithRightBranchQuestionResponse">
            <label for="choice2">Отказаться подниматься на мостик</label>
        </div>

        <div>
            <input type="submit" value="Ответить"/>
        </div>
    </div>
</form>
<%@ include file="bottomPagePath.jsp"%>
