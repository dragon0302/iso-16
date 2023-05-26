package dataManagment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ardressDAOimpl implements ardressDAO{

    private static DataSource ds;

    static {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            ds = (DataSource) envCtx.lookup("jdbc/catalogoiso16");
        }catch (NamingException e){
            System.out.println("errore:" + e.getMessage());
        }
    }

    private static final String TABLE_NAME = "indirizzo";

    public void doSave(ardress ardress) throws SQLException{

        Connection connection = null;
        PreparedStatement query = null;

        try {
            connection = ds.getConnection();
            query= connection.prepareStatement("INSERT INTO " + TABLE_NAME + "(Nazione, Città, Cap, Civico, Via, Codice_Fiscale_Cliente) VALUES (?,?,?,?,?,?)");
            query.setString(1,ardress.getNazzione());
            query.setString(2, ardress.getCitta());
            query.setInt(3,ardress.getCap());
            query.setInt(4,ardress.getCivico());
            query.setString(5,ardress.getVia());
            query.setString(6,ardress.getCF_cliente());

            query.executeUpdate();
        }finally {
            try {
                if (query != null){
                    query.close();
                }
            }finally {
                if (connection != null){
                    connection.close();
                }
            }
        }

    }

}
