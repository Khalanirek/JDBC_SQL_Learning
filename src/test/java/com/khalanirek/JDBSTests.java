package com.khalanirek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JDBSTests {

    @Test
    void connectionToDataBaseTest() {
        DataBaseConection dataBaseConection = new DataBaseConection();
        dataBaseConection.setDriverMySQL("com.mysql.cj.jdbc.Driver");
        dataBaseConection.setUsername("Spring");
        dataBaseConection.setPassword("spring");
        dataBaseConection.setUrl("jdbc:mysql://localhost:3306/nauka");
        dataBaseConection.startConnectionToDataBase();
        assertEquals(true, dataBaseConection.getConnectionStatus());
        dataBaseConection.closeConnectionToDataBase();
    }

}
