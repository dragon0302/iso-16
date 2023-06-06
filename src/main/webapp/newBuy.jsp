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

<form action="Ardress" method="POST">

    <%--@declare id="Codice_sconto"--%>
    <%--@declare id="Codice_prodotto"--%>
    <%--@declare id="Quantità"--%>
    <input type="hidden" name="action" value="insert">

    <label for="Codice_sconto">Codice sconto<textarea name="Codice_sconto" maxlength="20" required placeholder="Inserire la nazzione"></textarea></label>

    <label for="Codice_prodotto">Codice prodotto <textarea name="Codice_prodotto" maxlength="30" required placeholder="Inserire Città"></textarea></label>

    <label for="Quantità">Quantità<input name="Quantità" type="text" maxlength="10" required placeholder="Inserire Cap"></label>

    <input type="submit" value="add">
</form>



</body>
</html>
