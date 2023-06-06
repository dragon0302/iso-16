<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.example.webManagment.carello,dataManagment.product" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>prova del carello</title>
</head>
<body>
<h2>Catalogo</h2>
<h3>Inserimento</h3>

<form action="logIN" method="POST">

    <%--@declare id="Useranme"--%>
    <%--@declare id="PW"--%>
    <input type="hidden" name="action" value="insert">

    <label for="Useranme">Useranme<textarea name="Useranme" maxlength="20" required placeholder="Inserire la nazzione"></textarea></label>

    <label for="PW">password<textarea name="PW" maxlength="30" required placeholder="Inserire Città"></textarea></label>

    <input type="submit" value="add">
</form>

<%

    String messagio = (String) request.getAttribute("messagio");
    if (messagio != null && !messagio.isEmpty()){
        %>

        <p><%=messagio%></p>

    <%}%>

</body>
</html>
