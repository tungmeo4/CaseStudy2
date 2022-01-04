package io;

import model.Staff;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite {
    public static ArrayList<Staff> readFile() throws Exception {
        File file = new File("Staff.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream("Staff.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Staff> list = (ArrayList<Staff>) objectInputStream.readObject();
        objectInputStream.close();
        return list;
    }

    public static void writeFile(ArrayList<Staff> list) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("Staff.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
    }
}
