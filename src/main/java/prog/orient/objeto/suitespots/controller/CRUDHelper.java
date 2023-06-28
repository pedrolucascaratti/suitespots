package prog.orient.objeto.suitespots.controller;

import java.sql.Connection;

import prog.orient.objeto.suitespots.models.CRUDEntity;

public class CRUDHelper {
    private static CRUDHelper instance;
    private static DatabaseAux databaseAux;
    private static Connection connection;

    private CRUDHelper() {
        databaseAux = new DatabaseAux();
        connection = databaseAux.getConnection();
    }

    public static CRUDHelper getInstance() {
        if (instance == null) {
            instance = new CRUDHelper();
        }
        return instance;
    }

    // C - CREATE - OK

    public boolean create(CRUDEntity entity) {
        return entity.create(connection);
    }

    // R - READ - OK

    public CRUDEntity read(CRUDEntity entity) {
        return entity.read(connection);
    }

    // U - UPDATE - OK

    public boolean update(CRUDEntity entity) {
        return entity.update(connection);
    }

    // D - DELETE - OK

    public boolean delete(CRUDEntity entity) {
        return entity.delete(connection);
    }
}
