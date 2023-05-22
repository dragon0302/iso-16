package com.example.database;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class catalogo extends HttpServlet {

    catalogo(){super();}

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
                    cart.AggungiProdotto();

                    System.out.println("a+pdfingb");
                }
            }
        }

    }



}
