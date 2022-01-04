package model;

import java.io.Serializable;

public abstract class Staff implements Serializable {
    private int id;
    private String name;
    private String address;
    private int age;
    private String email;
    private double salary;
    private boolean status;

    public Staff(int id, String name, String address, int age, String email, double salary, boolean status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.email = email;
        this.salary = salary;
        this.status = status;
    }

    public Staff(String id, String name, String address, String age, String phone, String email, double salary, boolean status) {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public String status() {
        String status = null;
        if (this.status == true) {
            status = "Đang làm việc";
        } else {
            status = "Đã nghỉ";
        }
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double totalSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}

