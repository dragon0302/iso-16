package servlet;

import dataManagment.client;
import dataManagment.clientDAOimpl;
import dataManagment.clientDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class registration extends HttpServlet {

    clientDAO modello = new clientDAOimpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        String action = request.getParameter("action");

        try {
            if (action != null){

                client cliente = new client();

                cliente.setCF(request.getParameter("CF"));
                cliente.setNome(request.getParameter("Nome"));
                cliente.setCogniome(request.getParameter("Cogniome"));
                String data =(request.getParameter("Data_di_nascita"));
                cliente.setTelefono(request.getParameter("telefono"));
                cliente.setEmail(request.getParameter("Email"));
                cliente.setUsername(request.getParameter("Username"));
                cliente.setPW(request.getParameter("PW"));
                String[] date = data.split("/");
                String giorno = date[0];
                String mese = date[1];
                String anno = date[2];
                data = anno+"/"+mese+"/"+giorno;
                cliente.setData_di_nascita(data);
                modello.doSave(cliente);

            }
        }catch (Exception e){
            System.out.println("errore:" + e.getMessage());
        }

    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        doGet(request,response);
    }

}
