package QuanLyNhanSuPhenikaa;

import java.sql.*;

public class Employee {
    private int id;
    private String name;
    private String birthDate;
    private String jobTitle;
    private String hireDate;
    private double salary;

    // constructor
    public Employee(int id, String name, String birthDate, String jobTitle, String hireDate, double salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.jobTitle = jobTitle;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // connect to SQLite database
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:employee.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
