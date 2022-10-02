<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="upperPagePath.jsp"%>
<h2>Ты поднялся на мостик. Ты кто?</h2>
<form method="post" action="\questions">
    <input type="hidden" name="formname" value="question3"/>
    <div class="padding-inside">
        <div>
            <input type="radio" id="choice1" name="choice" value="FormWithLeftBranchQuestionResponse" checked>
            <label for="choice1">Рассказать правду о себе</label>
        </div>

        <div>
            <input type="radio" id="choice2" name="choice" value="FormWithRightBranchQuestionResponse">
            <label for="choice2">Солгать о себе</label>
        </div>

        <div>
            <input type="submit" value="Ответить"/>
        </div>
    </div>
</form>
<%@ include file="bottomPagePath.jsp"%>