package com.example.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class modelDS implements model {

    public modelDS(){}

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

    private static final String TABLE_NAME = "prodotto";

    public synchronized void doSave(prodotto nuovo) throws SQLException{

        Connection connection = null;
        PreparedStatement query= null;

        //String insertSQL = "INSERT INTO "+ TABLE_NAME + " (codice, prezzo, descrizzione, Categoria, Media_Valutazioni, Amministratore) VALUES (?,?,?,?,?,?)";


        try {
            connection = ds.getConnection();
            query = connection.prepareStatement("INSERT INTO "+ TABLE_NAME + " (codice, prezzo, descrizzione, Categoria, Media_Valutazioni, Amministratore, nome, quantità) VALUES (?,?,?,?,?,?,?,?)");
            query.setInt(1,nuovo.getCodice());
            query.setFloat(2,nuovo.getPrezzo());
            query.setString(3,nuovo.getDescrizione());
            query.setString(4,nuovo.getCategoria());
            query.setFloat(5,nuovo.getMedia_Valutazioni());
            query.setString(6,nuovo.getAmministratore());
            query.setString(6,nuovo.getNome());
            query.setInt(6,nuovo.getQuantità());

            query.executeUpdate();

        }finally {
            try {

                if (query != null){
                    query.close();
                }

            }finally {

                if (connection != null) {
                    connection.close();
                }
            }
        }

    }

    public synchronized prodotto doRetrieveByKey(int code) throws SQLException {

        Connection connection = null;
        PreparedStatement query = null;

        prodotto nuvo = new prodotto();

        String selectSQL = "select * FROM" + TABLE_NAME + "WERE COMDE=?";

        try {

            connection = ds.getConnection();
            query = connection.prepareStatement(selectSQL);
            query.setInt(1,code);

            ResultSet rs = query.executeQuery();

            while (rs.next()){

                nuvo.setCodice(rs.getInt("Codice"));
                nuvo.setPrezzo(rs.getFloat("prezzo"));
                nuvo.setDescrizione(rs.getString("descrizione"));
                nuvo.setCategoria(rs.getString("Categoria"));
                nuvo.setMedia_Valutazioni(rs.getFloat("Media_Valutazioni"));
                nuvo.setAmministratore(rs.getString("Amministratore"));

            }

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

        return nuvo;

    }

    public synchronized boolean doDelete(int code) throws SQLException{

        Connection connection = null;
        PreparedStatement query = null;

        int result = 0;

        String deleteSQL = "DELETE FROM" + TABLE_NAME + "WERE CODE=?";

        try{

            connection = ds.getConnection();
            query = connection.prepareStatement(deleteSQL);
            query.setInt(1,code);

            result = query.executeUpdate();

        }finally {
            try{
                if (query != null){
                    query.close();
                }
            }finally {
                if (connection != null){
                    connection.close();
                }
            }
        }

        return (result != 0);

    }

    public synchronized Collection<prodotto> doRetrieveAll(String order) throws SQLException{

        Connection connection = null;
        PreparedStatement query = null;

        Collection<prodotto> prodotti = new LinkedList<prodotto>();

        String selectSQL = "SELECT * FORM" + TABLE_NAME;

        if (order != null && !order.equals("")){
            selectSQL += " ORDER BY " + order;
        }

        try{

            connection = ds.getConnection();
            query = connection.prepareStatement(selectSQL);

            ResultSet rs = query.executeQuery();

            while (rs.next()){

                prodotto nuovo = new prodotto();

                nuovo.setCodice(rs.getInt("Codice"));
                nuovo.setPrezzo(rs.getFloat("prezzo"));
                nuovo.setDescrizione(rs.getString("descrizione"));
                nuovo.setCategoria(rs.getString("Categoria"));
                nuovo.setMedia_Valutazioni(rs.getFloat("Media_Valutazioni"));
                nuovo.setAmministratore(rs.getString("Amministratore"));
                nuovo.setNome(rs.getString("nome"));
                nuovo.setQuantità(rs.getInt("quantità"));
                prodotti.add(nuovo);


            }

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

        return  prodotti;

    }

}
