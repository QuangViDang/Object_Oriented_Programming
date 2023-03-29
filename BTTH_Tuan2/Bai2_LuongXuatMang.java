package BTTH_Tuan2;

import java.io.*;

class Bai2_LuongXuatMang{ 
    public static void main(String[] args)
    {
        try{
        //Tao mot luong xuat mang 100 byte
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            //Ghi du lieu vao luong
            for(byte i=0;i<100;i++) os.write(i);
            //Doc du lieu tu luong vao mang
            byte[] b = os.toByteArray();
            for(byte i=0;i<100;i++) System.out.print(b[i]+" ");
            os.close();
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
}