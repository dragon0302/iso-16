package com.example.database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/catalogo")
public class catalogo extends HttpServlet {

    model modello = new modelDS();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String action = request.getParameter("action");

        try {
            if (action != null) {

                prodotto nuovo = new prodotto();
                response.sendRedirect("index.jsp");

                int codice = Integer.parseInt(request.getParameter("codice"));
                float prezzo = Float.parseFloat(request.getParameter("prezzo"));
                String Descrizione = request.getParameter("descrizione");
                String categoria = request.getParameter("categoria");
                float media = Float.parseFloat(request.getParameter("Media Valutazioni"));
                String amministratore = request.getParameter("Amministratore");

                nuovo.setCodice(codice);
                nuovo.setPrezzo(prezzo);
                System.out.println("orezzo" + nuovo.getPrezzo());
                nuovo.setDescrizione(Descrizione);
                nuovo.setCategoria(categoria);
                nuovo.setMedia_Valutazioni(media);
                nuovo.setAmministratore(amministratore);
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
