package dataManagment;

import java.sql.SQLException;
import java.util.Collection;

public interface productDAO {

    public void doSave(product product) throws SQLException;

    public boolean doDelete(int code) throws SQLException;

    public product doRetrieveByKey(int code) throws SQLException;

    public Collection<product> doRetrieveAll(String order) throws SQLException;

}
