<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="upperPagePath.jsp"%>
<h2>Ты потерял память. Принять вызов НЛО?</h2>
<form method="post" action="\questions">
    <input type="hidden" name="formname" value="question1"/>
    <div class="padding-inside">
        <div>
        <input type="radio" id="choice1" name="choice" value="leftBranch" checked>
        <label for="choice1">Принять вызов</label>
        </div>

        <div>
        <input type="radio" id="choice2" name="choice" value="rightBranch">
        <label for="choice2">Отклонить вызов</label>
        </div>

        <div>
        <input type="submit" value="Ответить"/>
        </div>
    </div>
</form>
<%@ include file="bottomPagePath.jsp"%>
