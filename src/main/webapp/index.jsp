<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%

    Collection<?> prova = (Collection<?>) request.getAttribute("prodotti");
    if (prova == null){

        response.sendRedirect("./prodotto");
        return;

    }

     prodotto prodotti = (prodotto) request.getAttribute("prodotto");

    carello lista = (carello) request.getAttribute("carello");

%>

<!DOCTYPE html>
<html>

<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,com.example.database.carello,com.example.database.prodotto"%>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="prova.css" rel="pagina di stile" type="text/css">
    <title>prova del carello</title>
</head>
<body>
<h2> catalogo </h2>
<a href="prodotto">List</a>
<table border=1>
    <tr>
        <th>codice <a href="prodotto?sort=CF">Sort</a></th>
        <th>prezzo<a href="prodotto?sort=Nome">Sort</a></th>
        <th>Descrizione<a href="prodotto?sort=Cognome">Sort</a></th>
        <th>Action</th>

    </tr>
        <%

        if (prova != null && prova.size() != 0){

            Iterator<?> it = prova.iterator();
            while (it.hasNext()){

                prodotto newproduct = (prodotto) it.next();

        %>

    <tr>

        <td><% newproduct.getCodice();%></td>
        <td><% newproduct.getPrezzo();%></td>
        <td><% newproduct.getDescrizione();%></td>
        <td>

            <a href="prodotto?action=delete&id=<%=newproduct.getCodice()%>"></a>
            <a href="prodotto?action=read&id=<%=newproduct.getCodice()%>"></a>
            <a href="prodotto?action=add&id=<%=newproduct.getCodice()%>"></a>

        </td>

    </tr>

    <%

            }

        } else {

    %>

    <tr>
        <td colspan="6">No products available</td>
    </tr>

    <%

        }

    %>

</table>

<%

    if (prodotti != null){

%>

<table border=1>
    <tr>
        <th>codice</th>
        <th>prezzo</th>
        <th>categoria</th>
        <th>Media Valutazioni</th>
        <th>Amministratore</th>
    </tr>
    <tr>
        <th><%prodotti.getCodice();%></th>
        <th><%prodotti.getPrezzo();%></th>
        <th><%prodotti.getDescrizione();%></th>
        <th><%prodotti.getCategoria();%></th>
        <th><%prodotti.getMedia_Valutazioni();%></th>
        <th><%prodotti.getAmministratore();%></th>
    </tr>
</table>

<% } %>

<h2>Inserimento</h2>
<form action="prodotto" method="post">
<%--@declare id="prezzo"--%><%--@declare id="descrizione"--%><%--@declare id="categoria"--%><%--@declare id="media valutazioni"--%><%--@declare id="amministratore"--%><input type="hidden" name="action" value="insert">

<label for="prezzo">prezzo<input name="prezzo" type="text" maxlength="20" required placeholder="inserire nome"><br></label>

<label for="descrizione">descrizione<textarea name="descrizione" maxlength="120" rows="3" required placeholder="inserire cognome"></textarea><br></label>


<label for="categoria">categoria<textarea name="categoria" maxlength="10" required placeholder="inserire data di nascita"></textarea><br></label>


<label for="media valutazioni">media valutazioni<textarea name="media valutazioni" maxlength="10" required placeholder="inserire numero di telefono"></textarea><br></label>


<label for="Amministratore">Amministratore<textarea name="Amministratore" maxlength="100" required placeholder="inserire email"></textarea><br></label>


<input type="submit" value="add"><input type="reset" value="reset">
</form>

<%if (lista != null){%>

    <h2>Cart</h2>
    <table border="1">
        <tr>
            <th>name</th>
            <th>Action</th>
        </tr>

        <%

            List<prodotto> listaProdotti = lista.getProdotto();
            for (prodotto prodottiNuovi: listaProdotti){

        %>

        <tr>
            <td><%=prodottiNuovi.getPrezzo()%></td>
            <tb><a href="prodotto?action=deleteC&id=<%=prodottiNuovi.getCodice()%>">rimuovi dal carello</a></tb>
        </tr>

        <%}%>

    </table>

    <%}%>

</body>
</html>