package com.khalanirek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConection {

    private String url;
    private String username;
    private String password;
    private String driverMySQL;
    private boolean connectionStatus = false;
    private Connection connection;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverMySQL() {
        return driverMySQL;
    }

    public void setDriverMySQL(String driverMySQL) {
        this.driverMySQL = driverMySQL;
    }

    public boolean getConnectionStatus() {
        return connectionStatus;
    }

    public Connection getConnection() {
        return connection;
    }

    public Connection startConnectionToDataBase(){

        System.out.println( "-----  Nawiązywanie połączenia z bazą danych" );

        try{
            System.setProperty("jdbc.drivers", driverMySQL);
            System.setProperty("jdbc.dialect", driverMySQL);
            connection = DriverManager.getConnection(url, username, password);
            connectionStatus = !connection.isClosed();
            System.out.println("-----  Nawiązano połączenia z " + url);
            return connection;
        }

        catch (SQLException sql){
            System.out.println("-----  Nie udało się nawiązać połączenia z " + url);
            sql.printStackTrace();
            connectionStatus = false;
            return null;
        }
    }

    public void closeConnectionToDataBase(){

        try{
            connection.close();
            System.out.println("-----  Zamknięto połączenie z bazą danych");
        }
        catch (SQLException sql){
            System.out.println("-----  Nie udało się zamknąć połaczenia z bazą danych z powodu");
            sql.printStackTrace();
        }
    }

}
