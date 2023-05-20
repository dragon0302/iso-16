<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%

    Collection<?> prova = (Collection<?>) request.getAttribute("catalogoiso16");
    if (prova == null){

        response.sendRedirect("./catalogoiso16");
        return;

    }

    cliente clienti = (cliente) request.getAttribute("prodotto");

    carello lista = (carello) request.getAttribute("carello");

%>

<!DOCTYPE html>
<html>

<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,com.example.database.carello,com.example.database.cliente"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="prova.css" rel="pagina di stile" type="text/css">
    <title>prova del carello</title>
</head>
<body>
<%--@declare id="cogniome"--%>
<%--@declare id="nome"--%><%--@declare id="data di nascita"--%><%--@declare id="telefono"--%><%--@declare id="email"--%><%--@declare id="username"--%><%--@declare id="pw"--%><h2> catalogo </h2>
<a href="catalogo">List</a>
<table border=1>
    <tr>
        <th>CF <a href="product?sort=CF">Sort</a></th>
        <th>Nome<a href="product?sort=Nome">Sort</a></th>
        <th>Cogniome<a href="product?sort=Cognome">Sort</a></th>
        <th>Action</th>

    </tr>
        <%

        if (prova != null && prova.size() != 0){

            Iterator<?> it = prova.iterator();
            while (it.hasNext()){

                cliente newCliet = (cliente) it.next();

        %>

    <tr>

        <td><% newCliet.getCf();%></td>
        <td><% newCliet.getNome();%></td>
        <td><% newCliet.getCogniome();%></td>
        <td>

            <a href="product?action=delete&id=<%=newCliet.getCf()%>"></a>
            <a href="product?action=read&id=<%=newCliet.getCf()%>"></a>
            <a href="product?action=add&id=<%=newCliet.getCf()%>"></a>

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

    if (clienti != null){

%>

<table border=1>
    <tr>
        <th>CF</th>
        <th>Nome</th>
        <th>Cogniome</th>
        <th>Data di nascita</th>
        <th>Telefono</th>
        <th>Email</th>
        <th>UserName</th>
        <th>PW</th>
    </tr>
    <tr>
        <th><%clienti.getCf();%></th>
        <th><%clienti.getNome();%></th>
        <th><%clienti.getCogniome();%></th>
        <th><%clienti.getData_di_nascita();%></th>
        <th><%clienti.getTelefono();%></th>
        <th><%clienti.getEmail();%></th>
        <th><%clienti.getUserName();%></th>
        <th><%clienti.getPW();%></th>
    </tr>
</table>

<% } %>

<h2>Inserimento</h2>
<form action="catalogoiso16" method="post">
<input type="hidden" name="action" value="insert">

<label for="nome">Name</label>
<input name="nome" type="text" maxlength="20" required placeholder="inserire nome"><br>

<label for="cogniome">Cogniome</label>
<textarea name="cogniome" maxlength="120" rows="3" required placeholder="inserire cognome"></textarea><br>

<label for="Data di nascita">Data di nascita</label>
<textarea name="Data di nascita" maxlength="10" required placeholder="inserire data di nascita"></textarea><br>

<label for="Telefono">Telefono</label>
<textarea name="Telefono" maxlength="10" required placeholder="inserire numero di telefono"></textarea><br>

<label for="Email">Email</label>
<textarea name="Email" maxlength="100" required placeholder="inserire email"></textarea><br>

<label for="UserName">UserName</label>
<textarea name="UserName" maxlength="30" required placeholder="inserire username"></textarea><br>

<label for="PW">PW</label>
<textarea name="PW" maxlength="30" required placeholder="inserire la password"></textarea><br>

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

            List<cliente> listaClienti = lista.getClieti();
            for (cliente clientiNuovi: listaClienti){

        %>

        <tr>
            <td><%=clientiNuovi.getNome()%></td>
            <tb><a href="product?action=deleteC&id=<%=clientiNuovi.getCf()%>">rimuovi dal carello</a></tb>
        </tr>

        <%}%>

    </table>

    <%}%>

</body>
</html>