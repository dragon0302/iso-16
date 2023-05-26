package servlet;

import dataManagment.product;
import dataManagment.productDAO;
import dataManagment.productDAOimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/catalogo")
public class catalogo extends HttpServlet {

    productDAO modello = new productDAOimpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String action = request.getParameter("action");

        try {
            if (action != null) {

                product nuovo = new product();
                response.sendRedirect("index.jsp");

                int codice = Integer.parseInt(request.getParameter("codice"));
                float prezzo = Float.parseFloat(request.getParameter("prezzo"));
                String Descrizione = request.getParameter("descrizione");
                String categoria = request.getParameter("categoria");
                float media = Float.parseFloat(request.getParameter("Media Valutazioni"));
                String amministratore = request.getParameter("Amministratore");
                String nome = request.getParameter("nome");
                int quantità = Integer.parseInt(request.getParameter("quantità"));

                nuovo.setCodice(codice);
                nuovo.setPrezzo(prezzo);
                nuovo.setDescrizione(Descrizione);
                nuovo.setCategoria(categoria);
                nuovo.setMedia_Valutazioni(media);
                nuovo.setAmministratore(amministratore);
                nuovo.setNome(nome);
                nuovo.setQuantità(quantità);
                modello.doSave(nuovo);

            }

        }catch (Exception e){

            System.out.println("errore:" + e.getMessage());

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
