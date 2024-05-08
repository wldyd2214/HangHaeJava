package week05.thread.sleep;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                // (1) 예외처리 필수
                // (2) 특정 쓰레드 지목 불가
                // sleep 상태에서 누군가 interrupt 하게되면 sleep 깨지면서
                // InterruptedException 발생하기 때문에 예외처리 필수
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task, "Thread"); // NEW
        thread.start(); // NEW -> RUNNABLE

        try {
            // 메인 쓰레드가 1초 sleep
            // 특정 쓰레드 sleep 의미가 없다.
            // 메소드 자체가 static 메소드이기 때문에
            thread.sleep(1000);
            System.out.println("sleep(1000) : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}