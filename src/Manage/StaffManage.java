package Manage;

import Regex.Regex;
import io.ReadAndWrite;
import model.Staff;
import model.StaffFullTime;
import model.StaffPartTime;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffManage {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Staff> list = new ArrayList<>();

    static {
        try {
            list = ReadAndWrite.readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Staff staff) {
        list.add(staff);
        try {
            ReadAndWrite.writeFile(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        for (Staff staffs: list) {
            System.out.println(staffs);
            System.out.println("__________");
        }
    }

    public void findByName() {
        System.out.println("Ngài muốn tìm ai?");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.err.println("Tôi năm nay hơn 70 tuổi mà chưa gặp trường hợp nào nó như thế này cả!");
        } else {
            System.out.println(list.get(check));
        }
    }

    public void editByName() {
        System.out.println("Ngài muốn thay đổi tên của ai?");
        String names = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(names)) {
                check = i;
            }
        }

        if (check < 0) {
            System.out.println("Ngài chưa tạo ra người này!");
        } else {
            int id = getIdd();
            String name = getName();
            String address = getAddress();
            int age = getAge();
            String email = getEmail();
            double salary = getSalary();
            boolean status = getStatus();
            list.get(check).setId(id);
            list.get(check).setName(name);
            list.get(check).setAddress(address);
            list.get(check).setAge(age);
            list.get(check).setEmail(email);
            list.get(check).setSalary(salary);
            list.get(check).setStatus(status);
            if (list.get(check) instanceof StaffPartTime) {
                System.out.println("Ngài hãy nhập số giờ làm!");

                double workHours = Double.parseDouble(scanner.nextLine());
                ((StaffPartTime) list.get(check)).setWorkHour(workHours);
            }
        }
    }


    public void removeId() {
        System.out.println("nhập id cần xóa :");
        int id = Integer.parseInt(scanner.nextLine());
        int check=-1;
        for (int i = 0;i < list.size();i++){
            if(list.get(i).getId() == id){
                list.remove(i);
                check = i;
            }
        }
        if (check<0) {
            System.out.println("id không tồn tại");
        }
    }
    public  void editStatusStaff(){
        System.out.println("nhập tên nhân viên cần thay đổi trạng thái ");
        String names=scanner.nextLine();
        int check=-1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(names)){
                check=i;
            }

        }
        if (check<=0){
            System.out.println("không có tên trong danh sách");
        }else {
            if (list.get(check).isStatus()){
                list.get(check).setStatus(false);
            }else {
                list.get(check).setStatus(true);
            }
        }
    }

    public Staff create(boolean isParttime) {
        int id = getIdd();
        String name = getName();
        String address = getAddress();
        int age = getAge();
        String email = getEmail();
        double salary = getSalary();
        boolean status = getStatus();
        if (isParttime) {
            System.out.println("nhập số giờ làm:");
            double workHour = Double.parseDouble(scanner.nextLine());
            return new StaffPartTime(id, name, address, age, email, salary, status, workHour);
        } else {
            return new StaffFullTime(id, name, address, age, email, salary, status);
        }


    }

    private boolean getStatus() {
        while (true) {
            try {
                System.out.println("nhập Status đang làm:true, đang nghỉ:false");
                boolean status = false;
                String statuss = scanner.nextLine();
                if (statuss.equals("true")) {
                    status = true;
                } else if (statuss.equals("false")) {
                    status = false;
                } else {
                    throw new Exception();
                }
                return status;
            } catch (Exception e) {
                System.out.println("nhập lỗi:");
            }
        }
    }

    private double getSalary() {
        System.out.println("nhập lương");
        double salary = Double.parseDouble(scanner.nextLine());
        return salary;
    }

    private String getEmail() {
        while (true) {
            try {
                System.out.println("nhập email");
                String email = scanner.nextLine();
                if (Regex.validateEmail(email)) {
                    boolean check = true;
                    for (Staff nv : list) {
                        if (nv.getEmail().equals(email)) {
                            check = false;
                            break;
                        }

                    }
                    if (check) {
                        return email;
                    } else {
                        System.out.println("email đã tồn tại");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("nhập sai định dạng vui lòng nhập lại email");
            }
        }
    }

    public void SortStaff(){
        Sort sort = new Sort();
        list.sort(sort);

    }

    private int getAge() {
        while (true) {
            try {
                System.out.println("nhập tuổi nhân viên:");
                int age = Integer.parseInt(scanner.nextLine());
                if (age < 15 || age > 60) {
                    throw new Exception();
                } else return age;
            } catch (Exception e) {
                System.out.println("nhập lại tuổi nhân viên từ 15 tuổi đến 59 tuổi");
            }
        }
    }


    private String getAddress() {

        System.out.println("nhập địa chỉ :");
        return scanner.nextLine();
    }

    private String getName() {
        while (true) {
            try {
                System.out.println("nhập name:");
                String name = scanner.nextLine();
                if (Regex.validateName(name)) {
                    return name;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("name phải đúng định dạng :");
            }
        }

    }

    private int getIdd() {
        while (true) {
            try {
                System.out.println("nhập id :");
                int id = Integer.parseInt(scanner.nextLine());
                if (Regex.validateId(id)) {
                    for (Staff staffs : list) {
                        if (staffs.getId() == id) {
                            throw new Exception();
                        }
                        break;
                    }
                    return id;
                } else System.out.println("id nhập đúng định dạng là số (0-9)");
            } catch (Exception e) {
                System.out.println("Nhập id trùng,bạn nhập lại xem còn trùng không!!!!");
            }
            return -1;
        }
    }
}
