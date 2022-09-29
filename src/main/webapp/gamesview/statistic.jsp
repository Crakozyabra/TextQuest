<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="statistic">
    <div><b>Статистика:</b></div>
    <div>Твой текущий IP address: <i><%= session.getAttribute("ip")%></i></div>
    <div>Имя в игре: <i><%= session.getAttribute("username") %></i></div>
    <div>Количество игр: <i><%= session.getAttribute("gamesquanity")%></i></div>
</div>
