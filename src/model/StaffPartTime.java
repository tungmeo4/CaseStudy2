package model;

public class StaffPartTime extends Staff{
    private double workHour;

    public StaffPartTime(int id, String name, String address, int age, String email, double salary, boolean status, double workHour) {
        super(id, name, address, age, email, salary, status);
        this.workHour = workHour;
    }


    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    @Override
    public double totalSalary() {
        return getWorkHour()*getSalary();
    }

    @Override
    public String toString() {
        return "StaffFullTime{" + super.toString() + "Số giờ làm=" + workHour + " ," +"Tổng lương = "+ totalSalary() + " }";
    }


}
