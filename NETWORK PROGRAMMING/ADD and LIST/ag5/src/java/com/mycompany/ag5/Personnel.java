package com.mycompany.ag5;

public class Personnel {
    private String name;
    private String surname;
    private String employeeId;
    private String department;
    private String phone;
    private String startDate;
    private int salary;
    private boolean active;

    public Personnel(String name, String surname, String employeeId, String department, String phone, String startDate, int salary, boolean active) {
        this.name = name;
        this.surname = surname;
        this.employeeId = employeeId;
        this.department = department;
        this.phone = phone;
        this.startDate = startDate;
        this.salary = salary;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
