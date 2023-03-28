package BT_TH.BTTH_Tuan1;

public class Bai2_RunPingpong implements Runnable{
    String word;
    int delay;

    Bai2_RunPingpong(String word, int delay){
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
        Runnable ping = new Bai2_RunPingpong("ping", 33);
        Runnable pong = new Bai2_RunPingpong("pong", 33);
        new Thread(ping).start();
        new Thread(pong).start();
    }
    
}
