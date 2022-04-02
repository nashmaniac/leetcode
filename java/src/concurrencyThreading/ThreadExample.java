package concurrencyThreading;

public class ThreadExample {

    public static void simpleThreadDemo() {
        Thread thread = new Thread();
        thread.start();
    }

    public static class MyThreadClass extends Thread {
        @Override
        public void run() {
            System.out.println("Thread Running");
            System.out.println("Thread finished");
        }
    }

    public static class MyRunnableClass implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable class running");
            System.out.println("Runnable class finished");
        }
    }

    public static void extendingThreadClass() {
        Thread thread = new MyThreadClass();
        thread.start();
    }

    public static void implementingRunnableInterface() {
        Thread thread = new Thread(new MyRunnableClass());
        thread.start();
    }

    public static void inlineRunnableClass() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable variable running");
                System.out.println("Runnable variable finished");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void inlineRunnableClassImplement() {
        Runnable runnable = () -> {
            System.out.println("Runnable inline running");
            System.out.println("Runnable inline finished");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void threadingWithName() {

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };
        Thread thread = new Thread(runnable, "My First thread");
        thread.start();
    }

    public static void multipleThread() {

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };
        Thread thread = new Thread(runnable, "Thread1");
        thread.start();
        Thread thread2 = new Thread(runnable, "Thread2");
        thread2.start();
    }

    public static void sleepThread() {

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " running");
        };
        
        Thread thread = new Thread(runnable, "SleepThread1");
        thread.start();
        Thread thread2 = new Thread(runnable, "SleepThread2");
        thread2.start();
    }

    public static class StoppableRunner implements Runnable {
        private boolean stopRequested = false;

        public synchronized void setStopStatus() {
            this.stopRequested = true;
        }
        public synchronized boolean getStopStatus() {
            return this.stopRequested;
        }
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
            while(!getStopStatus()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("....");
            }
        }
    }

    public static void stopThread() {
        StoppableRunner runner = new StoppableRunner();
        Thread thread = new Thread(runner);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        runner.setStopStatus();
        System.out.println("Stopping the thread");
    }

    public static void daemonThread() {

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            for(int i=0;i<10;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + " running");
            } 
        };
        Thread thread = new Thread(runnable, "Daemon Thread");
        thread.setDaemon(true);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        simpleThreadDemo();
        System.out.println("------------------");
        extendingThreadClass();
        System.out.println("------------------");
        implementingRunnableInterface();
        System.out.println("------------------");
        inlineRunnableClass();
        System.out.println("------------------");
        inlineRunnableClassImplement();
        System.out.println("------------------");
        threadingWithName();
        System.out.println("------------------");
        multipleThread();
        System.out.println("------------------");
        sleepThread();
        System.out.println("------------------");
        stopThread();
        System.out.println("------------------");
        daemonThread();
        System.out.println("------------------");
        System.out.println("Finished Main Thread");
    }

}
