<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="\prologue">
  <div class="padding-inside">
    <input type="hidden" name="formname" value="endgame"/>
    <div>
      <input type="radio" id="choice1" name="choice" value="leftBranch" checked>
      <label for="choice1">Начать игру заново с пролога</label>
    </div>

    <div>
      <input type="radio" id="choice2" name="choice" value="rightBranch">
      <label for="choice2">Начать игру заново с первого вопроса</label>
    </div>

    <div>
      <input type="submit" value="Ответить"/>
    </div>
  </div>
</form>
