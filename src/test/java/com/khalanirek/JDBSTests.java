package com.khalanirek;

import com.khalanirek.database.DataBaseConection;
import com.khalanirek.database.DataBaseManager;
import com.khalanirek.database.database_Implementation.DataBaseManagerImp;
import com.khalanirek.domain.Student;
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
        dataBaseConection.setUrl("jdbc:mysql://localhost:3306/schooldatabase?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataBaseConection.startConnectionToDataBase();

        assertEquals(true, dataBaseConection.getConnectionStatus());
        dataBaseConection.closeConnectionToDataBase();
    }

    @Test
    void getStudentTest(){
        DataBaseManager dataBaseManager = new DataBaseManagerImp();
        Student student = dataBaseManager.getStudent(1);
        assertTrue(student.getClass() == Student.class);
    }

    @Test
    void writeStudentTest(){

    }

    @Test
    void getGuardianTest(){

    }

    @Test
    void writeGuardianTest(){

    }
}
