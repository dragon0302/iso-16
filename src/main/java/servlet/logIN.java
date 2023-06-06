package servlet;

import dataManagment.clientDAO;
import dataManagment.clientDAOimpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logIN")
public class logIN extends HttpServlet {

    clientDAO modello = new clientDAOimpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response){


        String action = request.getParameter("action");

        try {
            if (action != null){

                String registrazione = "se non possiedi un account puoi registrarti qui";
                if (modello.resercUser(request.getParameter("Useranme"),request.getParameter("PW"))) {
                    response.sendRedirect("home.jsp");
                }else {
                    request.setAttribute("messagio",registrazione);
                    request.getRequestDispatcher("logIN.jsp").forward(request,response);
                }

            }
        }catch (Exception e){
            System.out.println("errore:" + e.getMessage());
        }

    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        doGet(request,response);
    }

}
