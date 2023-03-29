package BTTH_Tuan2;

import java.io.*;
    public class Bai4
    {
        static String filename="dayso.dat";
        final static int INT_SIZE=4;
        //Tao file de ghi
    public void createFile() throws IOException
    {
        File datFile = new File(filename);
        RandomAccessFile out_file = new RandomAccessFile(datFile,"rw");
        for(int i=0;i<10;i++)out_file.writeInt(i*i);
        out_file.close();
    }
    //Mo file de doc
    public void readFile() throws IOException
    {
        File datFile = new File(filename); 

        RandomAccessFile inp_file= new RandomAccessFile(datFile,"r");
        System.out.println("Cac so doc tu file:");
        long len = inp_file.length();
        for(int i=INT_SIZE;i<len;i+=2*INT_SIZE)
        {
        inp_file.seek(i);
        System.out.println(inp_file.readInt());
        }
        inp_file.close();
        }
        //Mo file de ghi
        public void extendFile() throws IOException
        {
        RandomAccessFile out_file = new RandomAccessFile(filename,"rw");
        for(int i=10;i<20;i++) out_file.writeInt(i*i);
        out_file.close();
        }
        public static void main(String[] args)
        {
            try{
                Bai4 rnd = new Bai4();
                rnd.createFile();
                rnd.readFile();
                rnd.extendFile();
                rnd.readFile();
            }
        catch(IOException e){
            System.err.println(e);
        }
    }
} 