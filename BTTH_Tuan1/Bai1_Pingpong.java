package BT_TH.BTTH_Tuan1;

public class Bai1_Pingpong extends Thread {
    String word;
    int delay;

    Bai1_Pingpong(String word, int delay){
        this.word=word;
        this.delay=delay;
    }
    public void run(){
        try{
            for(;;){
                System.out.println(word + " ");
                Thread.sleep(delay);
            }
        }
        catch(InterruptedException e)
        {
            return;
        }
    }
    public static void main(String[] args){
        new Bai1_Pingpong("ping", 33).start();
        new Bai1_Pingpong("ping", 100).start();
    }
}
