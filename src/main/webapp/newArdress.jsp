<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.example.webManagment.carello,dataManagment.product" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<link href="prova.css" rel="pagina di stile" type="text/css">--%>
    <title>prova del carello</title>
</head>
<body>
<h2>Catalogo</h2>
<h3>Inserimento</h3>

<form action="Ardress" method="POST">

    <%--@declare id="Nazzione"--%>
    <%--@declare id="Città"--%>
    <%--@declare id="Cap"--%>
    <%--@declare id="Civico"--%>
    <%--@declare id="Via"--%>
    <%--@declare id="CF_cliente"--%>
    <input type="hidden" name="action" value="insert">

    <label for="Nazzione">Nazzione <textarea name="Nazzione" maxlength="30" required placeholder="Inserire la nazzione"></textarea></label>

    <label for="Città">Città <textarea name="Città" maxlength="30" required placeholder="Inserire Città"></textarea></label>

    <label for="Cap">Cap<input name="Cap" type="text" maxlength="10" required placeholder="Inserire Cap"></label>

    <label for="Civico">Civico<input name="Civico" type="text" maxlength="10" required placeholder="Inserire Civico"></label>

    <label for="Via">Via <textarea name="Via" maxlength="100" required placeholder="Inserire Via"></textarea></label>

    <label for="CF_cliente">codice fiscale cliente <textarea name="CF_cliente" maxlength="16" required placeholder="Inserire CF_cliente"></textarea></label>

    <input type="submit" value="add">
</form>



</body>
</html>
