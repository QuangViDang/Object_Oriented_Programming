package BT_TH.BTTH_Tuan1;

public class Bai4_ThreadExample implements Runnable {
    public void run() {
        System.out.println("Luồng đang chạy");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Luồng bị gián đoạn");
        }
        System.out.println("Luồng đã kết thúc");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Bai4_ThreadExample());
        t.start();
        System.out.println("Luồng đang hoạt động: " + t.isAlive());
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Luồng bị gián đoạn");
        }
        System.out.println("Luồng đã kết thúc: " + t.isAlive());
    }
}