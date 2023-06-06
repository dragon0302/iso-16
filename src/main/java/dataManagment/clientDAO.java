package dataManagment;

import java.sql.SQLException;

public interface clientDAO {

    public void doSave(client cliente) throws SQLException;

    public boolean resercUser(String Username, String passuword) throws SQLException;

    public boolean existingUser(String Username) throws  SQLException;

}
