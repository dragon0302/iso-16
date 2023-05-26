package dataManagment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clientDAOimpl implements clientDAO {

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

    private static final String TABLE_NAME = "cliente";

    public synchronized void doSave(client cliente) throws SQLException {

        Connection connection = null;
        PreparedStatement query = null;

        try {

            connection = ds.getConnection();
            query = connection.prepareStatement("INSERT INTO" + TABLE_NAME +" Cliente (CF, Nome, Cognome, Data_di_nascita, Telefono, Email, Username, PW) VALUES (?,?,?,?,?,?,?,?)");
            query.setString(1,cliente.getCF());
            query.setString(2,cliente.getNome());
            query.setString(3,cliente.getCogniome());
            query.setString(4,cliente.getData_di_nascita());
            query.setString(5,cliente.getTelefono());
            query.setString(6,cliente.getEmail());
            query.setString(7,cliente.getUsername());
            query.setString(8,cliente.getPW());

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
