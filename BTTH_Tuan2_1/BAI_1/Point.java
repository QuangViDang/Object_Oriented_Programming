package BTTH_Tuan2_1.BAI_1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = 1L;
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        Point[] points = { new Point(1, 2), new Point(3, 4), new Point(5, 6) };
        String filename = "points.txt";

        try {
            FileWriter writer = new FileWriter(filename);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(points);
            oos.close();
            System.out.println("Serialized data is saved in " + filename);

            BufferedReader reader = new BufferedReader(new FileReader(filename + ".txt"));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                points[i] = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                i++;
            }
            reader.close();
            System.out.println("Text data is read from " + filename + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Points:");
        for (Point p : points) {
            System.out.println(p.getX() + "," + p.getY());
        }
    }
}