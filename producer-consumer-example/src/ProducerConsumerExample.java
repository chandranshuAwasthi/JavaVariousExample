import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class ProducerConsumerExample {

    public static void main(String[] args) {

        BlockingQueue blockingQueue=new BlockingQueue();
        ProducerThread producerThread=new ProducerThread(blockingQueue);
        producerThread.setName("Producer Thread");
        ConsumerThread cunsumerThred= new ConsumerThread(blockingQueue);
        cunsumerThred.setName("Consumer Thread");
        cunsumerThred.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producerThread.start();
    }
}

class ProducerThread extends Thread {

    private BlockingQueue blockingQueue;


    public ProducerThread(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
//        while(true){
//            if(blockingQueue.isTerminated){
//                break;
//            }
//
//            blockingQueue.producer();
//        }
        blockingQueue.producer();
    }


}


class ConsumerThread extends Thread {

    private BlockingQueue blockingQueue;

    public ConsumerThread(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {

//        while(true){
//
//            if(blockingQueue.isTerminated){
//                break;
//            }
//            blockingQueue.consumer();
//        }

        blockingQueue.consumer();
//        try {
//            join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


}


class BlockingQueue {

    Queue<Long> queueOfValues = new LinkedList<>();

    boolean isTerminated = false;

    boolean isEmptyBooleean = true;

    int capacity = 5;

    long maxValue=500;


    public synchronized void producer() {


        while (true) {
            if (Generator.getUpdatedValue() > maxValue) {
                System.out.println("No more values to process so producer got terminated");
                isTerminated = true;
                notify();
                break;
            }


            if (queueOfValues.size() == capacity) {
               // System.out.println("Inside Wait block");
                try {
                   // notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queueOfValues.add(Generator.getUpdatedValue());
            isEmptyBooleean = false;
            notify();
            System.out.println(Thread.currentThread().getName() + " :" + queueOfValues.size());


        }
      //  System.out.println("Finished Processing");
    }


    public  void consumer() {

        while (true) {
           System.out.println("Waiting to get monitor");

            synchronized (this) {
             //   System.out.println("Inside Consumer");
// queueOfValues.size() == 0 &&
                if ( isTerminated) {
                    System.out.println("No more  data to consume : " + Thread.currentThread().getName());
                    return;
                }

                if (queueOfValues.size() == 0) {
                    //notifyAll();
                    System.out.println("Inside queueOfValues.size()");
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    return;
                }
               System.out.println(Thread.currentThread().getName() + " : " + queueOfValues.size());
                long k = queueOfValues.remove();

                if (queueOfValues.size() == (capacity - 1)) {
                    notify();
                   // System.out.println("Inside Capacity Block");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }


    }


     static class Generator {
        public static long counter = 1;

        private  static  AtomicLong atomicInteger = new AtomicLong(1);

         static long   getUpdatedValue() {

            return atomicInteger.getAndIncrement();
        }


    }


}