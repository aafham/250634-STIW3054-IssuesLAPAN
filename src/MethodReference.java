class ThreadOne implements Runnable {
    public void run() {
        try {
            for(int i=0;i<10;i++) {
                if(!(i%2==1)){
                    Thread.sleep(500);
                    System.out.println("Thread 1: "+i);
                }
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadTwo implements Runnable {
    public void run() {
        try {
            for(int i=0;i<10;i++) {
                if(!(i%2==0)) {
                    Thread.sleep(500);
                    System.out.println("Thread 2: "+i);
                }
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MethodReference {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadOne());
        t1.start();
        t1.join();

        Thread t2 = new Thread(new ThreadTwo());
        t2.start();
        t2.join();

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long timeSpend = endTime - startTime;
        System.out.println();
        System.out.println("Execution Time ="+timeSpend+ "ms");
    }
}