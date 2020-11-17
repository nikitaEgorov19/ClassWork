package task1;


public class Main {
    public static void main(String[] args){
        Object look = new Object();
        Thread thread = Thread();
            @Override
            public void run() {
                System.out.println(getState());
                try {
                    synchronized (look) {
                        look.notifyAll();
                        look.wait(1500);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        synchronized (look) {
            System.out.println(thread.getState());
            thread.start();
            look.wait();
            System.out.println(thread.getState());
            look.notifyAll();
            System.out.println(thread.getState());
        }
        try {
            thread.join();
        } catch (InterruptedException e) {}
        System.out.println(thread.getState());
    }
}