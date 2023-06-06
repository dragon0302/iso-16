package servlet;

import dataManagment.BuyDAO;
import dataManagment.BuyDAOimpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Buy")
public class NewBuy extends HttpServlet {

    BuyDAO model = new BuyDAOimpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        String action = request.getParameter("action");

    }

}
