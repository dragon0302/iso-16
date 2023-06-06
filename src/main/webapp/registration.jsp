<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>registration</title>
</head>
<body>
<h2>registration</h2>

<form action="registration" method="post">

    <%--@declare id="cf"--%>
    <%--@declare id="nome"--%>
    <%--@declare id="cogniome"--%>
    <%--@declare id="data_di_nascita"--%>
    <%--@declare id="telefono"--%>
    <%--@declare id="email"--%>
    <%--@declare id="username"--%>
    <%--@declare id="pw"--%>
    <input type="hidden" name="action" value="insert">

    <label for="CF">Codice Fiscale<textarea name="CF" maxlength="16" required placeholder="inserire codice fiscale"></textarea></label>

    <label for="Nome">Nome<textarea name="Nome" maxlength="30" required placeholder="inserire nome"></textarea></label>

    <label for="Cogniome">Cogniome<textarea name="Cogniome" maxlength="30" required placeholder="inserire cogniome"></textarea></label>

    <label for="Data_di_nascita">Data di nascita<textarea name="Data_di_nascita" maxlength="10" required placeholder="inserire data di nascita"></textarea></label>

    <label for="telefono">telefono<textarea name="telefono" maxlength="20" required placeholder="inserire telefono"></textarea></label>

    <label for="Email">Email<textarea name="Email" maxlength="100" required placeholder="inserire Email"></textarea></label>

    <label for="Username">Username<textarea name="Username" maxlength="30" required placeholder="inserire Username"></textarea></label>

    <label for="PW">PW<textarea name="PW" maxlength="30" required placeholder="inserire PW"></textarea></label>

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
