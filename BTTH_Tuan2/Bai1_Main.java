package BTTH_Tuan2;

import java.io.*;

public class Bai1_Main {
  public static void main(String[] args) {
    byte[] arr = new byte[100];
      // Nhập dữ liệu vào mảng byte
      for (int i = 0; i < arr.length; i++) {
        arr[i] = (byte) i;
      }
    try {
      InputStream is = new ByteArrayInputStream(arr);

      // In mảng byte ra màn hình
      for (int i = 0; i < arr.length; i++) {
        System.out.print(is.read() + " ");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}