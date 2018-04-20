package com.khalanirek.database;

import com.khalanirek.domain.Guardian;
import com.khalanirek.domain.Student;

public interface DataBaseManager {

    /**
     * Get student from database.
     * @param studentId students Id.
     * @return Student object.
     */
    Student getStudent(int studentId);

    /**
     * Write student to database.
     * @param student Student object.
     * @return studentId students Id.
     */
    int writeStudent(Student student);

    /**
     * Get guardian from database.
     * @param guardianId guardians Id.
     * @return Guardian object.
     */
    Guardian getGuardian(int guardianId);

    /**
     * Write guardian to database.
     * @param guardian guardians Id.
     * @return guardianId.
     */
    int writeGuardian(Guardian guardian);
}
