package dataManagment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuyDAOimpl implements BuyDAO {

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

    private static final String TABLE_NAME ="acquisto";

    public synchronized void doSave(Buy buy) throws SQLException {

        Connection connection = null;
        PreparedStatement query = null;

        try {

            connection = ds.getConnection();
            query = connection.prepareStatement("INSERT INTO " + TABLE_NAME + " (Codice_sconto, Codice_Prodotto, Quantità) VALUES (?,?,?)");
            query.setString(1, buy.getCodiceSconto());
            query.setString(2, buy.getCodiceProdotto());
            query.setInt(3, buy.getQuantità());

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
