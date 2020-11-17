package wait.notify;

public class Store {
    private int product = 0;
    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Клиент купил один товар");
        notify();
    }

}
