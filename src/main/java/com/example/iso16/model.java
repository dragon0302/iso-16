package com.example.iso16;

import java.sql.SQLException;
import java.util.Collection;

public interface model {

    public void doSave(prodotto product) throws SQLException;

    public boolean doDelete(int code) throws SQLException;

    public prodotto doRetrieveByKey(int code) throws SQLException;

    public Collection<prodotto> doRetrieveAll(String order) throws SQLException;

}
