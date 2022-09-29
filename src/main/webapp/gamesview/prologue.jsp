<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="upperPagePath.jsp"%>
<h2>Пролог</h2>
<p class="padding-left">
    Ты стоишь в космическом порту и готов подняться на борт своего корабля. Разве ты не об этом мечтал?
    Стать капитаном галактического судна с экипажем, который будет совершать подвиги под твоим командованием.
    Так что вперед!
</p>
<h2>Знакомство с экипажем</h2>
<p class="padding-left">
    Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:
    - Здраствуйте, коммандир! Я Зинаида - ваша помошница. Видите? Там в углу пьет кофе наш штурман - сержант
    Перегарный Шлейф, под штурвалом спит наш бортмихание - Черный Богдам, а фотографирует его Сергей Стальная
    Пятка - наш навигатор. А как обращаться к вам?
</p>
<form method="post" action="\questions">
    <input type="hidden" name="formname" value="prologue"/>
    <label>
        <input name="username" type="text" value="">
    </label>
    <input type="submit" value="Представиться"/>
</form>
<%@ include file="bottomPagePath.jsp"%>
