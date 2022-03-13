package mySingletonDemo;

public class DatabaseConnector {
    private static DatabaseConnector connector;
    private Database database;

    private DatabaseConnector() {
        database = new Database();
    }

    public static DatabaseConnector getConnector() {
        if (connector == null) {
            connector = new DatabaseConnector();
        }
        return connector;
    }

    public void addData(String data) {
        this.database.addData(data);
    }
}
