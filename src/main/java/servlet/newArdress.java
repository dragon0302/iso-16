package servlet;

import dataManagment.ardress;
import dataManagment.ardressDAO;
import dataManagment.ardressDAOimpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Ardress")
public class newArdress extends HttpServlet {
    ardressDAO modello = new ardressDAOimpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        String action = request.getParameter("action");

        try {
            if (action != null){

                ardress ardress = new ardress();

                ardress.setNazzione(request.getParameter("Nazzione"));
                ardress.setCitta(request.getParameter("Città"));
                ardress.setCap(Integer.parseInt(request.getParameter("Cap")));
                ardress.setCivico(Integer.parseInt(request.getParameter("Civico")));
                ardress.setVia(request.getParameter("Via"));
                ardress.setCF_cliente(request.getParameter("CF_cliente"));
                modello.doSave(ardress);

            }
        }catch (Exception e){
            System.out.println("errore:" + e.getMessage());
        }

    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        doGet(request,response);
    }

}
