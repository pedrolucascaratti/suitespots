package prog.orient.objeto.suitespots.models;

import java.sql.Connection;

public interface CRUDEntity {
    public boolean create(Connection connection);

    public CRUDEntity read(Connection connection);

    public boolean update(Connection connection);

    public boolean delete(Connection connection);
}