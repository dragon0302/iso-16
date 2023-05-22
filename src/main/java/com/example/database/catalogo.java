package com.example.database;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class catalogo extends HttpServlet {

    catalogo(){super();}

    model modello = new modelDS();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        carello cart = (carello) request.getSession().getAttribute("cart");
        if (cart == null){

            cart = new carello();
            request.getSession().setAttribute("cart",cart);

        }

        String action = request.getParameter("action");

        try {
            if (action != null){
                if (action.equalsIgnoreCase("add")){
                    int id = Integer.parseInt(request.getParameter("id"));
                    cart.AggungiProdotto(modello.doRetrieveByKey(id));
                } else if (action.equalsIgnoreCase("deleteC")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    cart.rimuoviProdotto(modello.doRetrieveByKey(id));
                } else if (action.equalsIgnoreCase("read")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    request.removeAttribute("product");
                    request.setAttribute("product", modello.doRetrieveByKey(id));
                } else if (action.equalsIgnoreCase("delete")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    modello.doDelete(id);
                } else if (action.equalsIgnoreCase("insert")) {
                    float prezzo = Float.parseFloat(request.getParameter("prezzo"));
                    String descrizione = request.getParameter("descrizione");
                    String categoria = request.getParameter("price");
                    float Media_Valutazioni = Float.parseFloat(request.getParameter("Media_Valutazioni"));
                    String Amministratore = request.getParameter("Amministratore");

                    prodotto nuovo = new prodotto();
                    nuovo.setPrezzo(prezzo);
                    nuovo.setDescrizione(descrizione);
                    nuovo.setCategoria(categoria);
                    nuovo.setMedia_Valutazioni(Media_Valutazioni);
                    nuovo.setAmministratore(Amministratore);
                    modello.doSave(nuovo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        request.getSession().setAttribute("cart", cart);
        request.setAttribute("cart", cart);


        String sort = request.getParameter("sort");

        try {
            request.removeAttribute("products");
            request.setAttribute("products", modello.doRetrieveAll(sort));
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
