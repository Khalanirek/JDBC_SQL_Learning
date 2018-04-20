package com.khalanirek.domain;

public class Student extends Person {

   private int studentId;
   private String schoolClass;

    public Student(int studentId, String name, String surname, String address, String phone, String schoolClass) {
        this.studentId = studentId;
        this.schoolClass = schoolClass;
        this.setName(name);
        this.setSurname(surname);
        this.setAddress(address);
        this.setPhoneNumber(phone);
        this.setSchoolClass(schoolClass);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }
}
