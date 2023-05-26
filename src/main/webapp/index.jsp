<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,com.example.webManagment.carello,dataManagment.product" %>

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

<form action="catalogo" method="POST">

    <%--@declare id="nome"--%>
    <%--@declare id="prezzo"--%>
    <%--@declare id="quantità"--%>
    <%--@declare id="descrizione"--%>
    <%--@declare id="categoria"--%>
    <%--@declare id="media_valutazioni"--%>
    <%--@declare id="Amministratore"--%>
    <%--@declare id="codice"--%>
    <input type="hidden" name="action" value="insert">

    <label for="codice">codice <textarea name="codice" maxlength="10" required placeholder="Inserire codice"></textarea></label>

    <label for="nome">Nome <textarea name="nome" maxlength="50" required placeholder="Inserire nome"></textarea></label>

    <label for="prezzo">Prezzo<input name="prezzo" type="text" maxlength="10" required placeholder="Inserire prezzo"></label>

    <label for="quantità">Quantità<input name="quantità" type="text" maxlength="5" required placeholder="Inserire quantità"></label>

    <label for="descrizione">Descrizione <textarea name="descrizione" maxlength="300" required placeholder="Inserire descrizione"></textarea></label>

    <label for="categoria">Categoria <textarea name="categoria" maxlength="15" required placeholder="Inserire Categoria"></textarea></label>

    <label for="media_valutazioni">Media Valutazioni <input name="Media Valutazioni" type="text" maxlength="10" required placeholder="Inserire media valutazioni"></label>

    <label for="Amministratore">Amministratore <textarea name="Amministratore" maxlength="30" required placeholder="Inserire Amministratore"></textarea></label>

    <input type="submit" value="add">
</form>



</body>
</html>