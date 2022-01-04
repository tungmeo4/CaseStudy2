package Manage;

import model.Staff;

import java.util.Comparator;

public class Sort implements Comparator<Staff> {


    @Override
    public int compare(Staff o1, Staff o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
