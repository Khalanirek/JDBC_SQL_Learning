package com.khalanirek;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        //Nawiązywanie połączenia z bazą danych
        DataBaseConection dataBaseConection = new DataBaseConection();
        dataBaseConection.setDriverMySQL("com.mysql.cj.jdbc.Driver");
        dataBaseConection.setUsername("Spring");
        dataBaseConection.setPassword("spring");
        dataBaseConection.setUrl("jdbc:mysql://localhost:3306/nauka?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        Connection connection = dataBaseConection.startConnectionToDataBase();

        //Operacje na baziedanych
        try(Statement statement = connection.createStatement()) {
            try {
                String mySQLQuery = "SELECT * FROM nauka.uczniowie";
                ResultSet resultSet = statement.executeQuery(mySQLQuery);
                while (resultSet.next()) {
                    System.out.println(resultSet.getRow());
                }

            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }

        //Zamknięcie połączenia z bazą danych
        dataBaseConection.closeConnectionToDataBase();

    }
}
