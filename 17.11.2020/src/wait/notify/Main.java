package wait.notify;

import com.company.CommonResurse;

public class Main {
    public static void main(String[] args){
        Store store = new Store();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
