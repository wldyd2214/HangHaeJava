package week05.thread;

// 1. Thread Class를 이용하는 것(상속)
//
public class TestThread extends Thread {
    @Override
    public void run() {
        // 실제 우리가 쓰레드에서 수행한 작업
        for (int i=0; i<100; i++) {
            System.out.print("*");
        }
    }
}
