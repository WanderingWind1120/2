package org.example;

import java.io.*;
import java.util.ArrayList;

public class StudentDatabase {


    /*
      - Ghi Array object student vào trong file cơ sở dữ liệu
      - Writeobject bằng oos vào
     */
    public void write(ArrayList<Student> studentArrayList) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("Database.txt")));
            oos.writeObject(studentArrayList);
            // Viết object vào trong file đường dẫn dữ liệu đã chọn, file cở sở dữ liệu nằm trong source nên
            // không cầ absolute path
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(oos);
        }
    }

    /* Đọc thông tin các object student trong cơ sở dữ liệu và trả về 1 ArrayList of object student
     */
    public ArrayList<Student> read() {
        ArrayList<Student> studentArrayList = new ArrayList<>();

        ObjectInputStream ois = null;
        try {

            ois = new ObjectInputStream(new FileInputStream(new File("Database.txt")));
            studentArrayList = (ArrayList<Student>) ois.readObject();
            // Ghi dữ liệu đang đọc trong file đã chọn vào trong ArrayList đã thiết lập và gán loại class hay
            // chính dữ liệu
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(ois);
        }
        return studentArrayList;
    }

    // Đóng InputStream còn đang mở
    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Đóng Output Stream còn đang mở
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
