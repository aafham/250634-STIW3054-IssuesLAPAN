public class MethodReference {
    public static void main(String [] args){

        Runnable r1 = new RunnableOne();
        Runnable r2 = new RunnableTwo();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
    static class RunnableOne implements Runnable{
        public void run(){
            long start =System.currentTimeMillis();
            for(int i=0; i<10; i+=2) {
                System.out.println(Thread.currentThread().getName()+": "+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long end =System.currentTimeMillis();
            System.out.println("Execution Time = "+(end-start)/1000+"s");
        }
    }
    static class RunnableTwo implements Runnable{
        public void run(){
            for(int i=1; i<10; i+=2){
                System.out.println(Thread.currentThread().getName()+": "+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
