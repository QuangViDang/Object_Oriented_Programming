package BTTH_Tuan2_1.BAI_2;

import java.io.*;
import java.util.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private float gpa;

    public Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public float getGPA() {
        return gpa;
    }
}

public class SortStudents {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Quang", 10.0f));
        students.add(new Student("Vi", 9.5f));
        students.add(new Student("Dang", 9.8f));
        String filename = "students.dat";

        try {
            FileOutputStream os = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(students);
            oos.close();
            System.out.println("Serialized data is saved in " + filename);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            List<Student> sortedStudents = (List<Student>) ois.readObject();
            Collections.sort(sortedStudents, Comparator.comparing(Student::getGPA));
            ois.close();

            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("sxsv.dat"));
            oos2.writeObject(sortedStudents);
            oos2.close();
            System.out.println("Sorted data is saved in sxsv.dat");

            System.out.println("Students:");
            for (Student s : sortedStudents) {
                System.out.println(s.getName() + " - " + s.getGPA());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}