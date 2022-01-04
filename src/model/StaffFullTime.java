package model;

public class StaffFullTime extends Staff{

    public StaffFullTime(int id, String name, String address, int age, String email, double salary, boolean status) {
        super(id, name, address, age, email, salary, status);
    }

    @Override
    public double totalSalary() {
        return super.totalSalary();
    }

    @Override
    public String toString() {
        return "StaffFullTime{"+ super.toString()+ "tổng lương"+ totalSalary() +" }";
    }
}
