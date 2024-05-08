package week05.thread.interupt;

public class Main {
//    public static void main(String[] args) {
//        Runnable task = () -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("task : " + Thread.currentThread().getName());
//        };
//
//        Thread thread = new Thread(task, "Thread");
//        thread.start();
//
//        thread.interrupt();
//
//        System.out.println("thread.isInterrupted() = " + thread.isInterrupted());
//
//    }

    public static void main(String[] args) {
        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("task : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task, "Thread");
        thread.start();

        thread.interrupt();

        System.out.println("thread.isInterrupted() = " + thread.isInterrupted());

    }
}
