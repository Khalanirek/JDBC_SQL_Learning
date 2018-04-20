package com.khalanirek.database.database_Implementation;

import com.khalanirek.database.DataBaseConection;
import com.khalanirek.database.DataBaseManager;
import com.khalanirek.domain.Guardian;
import com.khalanirek.domain.Student;

import java.sql.*;

public class DataBaseManagerImp implements DataBaseManager{

    private DataBaseConection dataBaseConection;
    private Connection connection;

    public DataBaseManagerImp() {
        dataBaseConection = new DataBaseConection();
        dataBaseConection.setDriverMySQL("com.mysql.cj.jdbc.Driver");
        dataBaseConection.setUsername("Spring");
        dataBaseConection.setPassword("spring");
        dataBaseConection.setUrl("jdbc:mysql://localhost:3306/schooldatabase?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
    }

    /**
     * Get student from database.
     * @param studentId students Id.
     * @return Student object.
     */
    @Override
    public Student getStudent(int studentId) {
        connection = dataBaseConection.startConnectionToDataBase();
        String mySQLQuery = "SELECT * FROM schooldatabase.students WHERE studentId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(mySQLQuery)) {
            try {

                preparedStatement.setInt(1 ,studentId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Student student = new Student(
                            studentId,
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6));
                    dataBaseConection.closeConnectionToDataBase();
                    return student;
                }

            }
            catch (SQLException sql) {
                sql.printStackTrace();
                dataBaseConection.closeConnectionToDataBase();
                return null;
            }
        }
        catch (SQLException sql) {
            sql.printStackTrace();
            dataBaseConection.closeConnectionToDataBase();
            return null;
        }
        dataBaseConection.closeConnectionToDataBase();
        return null;
    }


    /**
     * Write student to database.
     * @param student Student object.
     * @return studentId students Id.
     */
    @Override
    public int writeStudent(Student student) {
        connection = dataBaseConection.startConnectionToDataBase();
        dataBaseConection.closeConnectionToDataBase();
        return 0;
    }


    /**
     * Get guardian from database.
     * @param guardianId guardians Id.
     * @return Guardian object.
     */
    @Override
    public Guardian getGuardian(int guardianId) {
        connection = dataBaseConection.startConnectionToDataBase();
        dataBaseConection.closeConnectionToDataBase();
        return null;
    }


    /**
     * Write guardian to database.
     * @param guardian guardians Id.
     * @return guardianId.
     */
    @Override
    public int writeGuardian(Guardian guardian) {
        connection = dataBaseConection.startConnectionToDataBase();
        dataBaseConection.closeConnectionToDataBase();
        return 0;
    }
}
