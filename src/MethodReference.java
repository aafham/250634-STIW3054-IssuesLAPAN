public class MethodReference {
    public static void main(String [] args){

        Thread t1 = new Thread(MethodReference::thread1Even);
        Thread t2 = new Thread(MethodReference::thread2Odd);

        t1.start();
        t2.start();
    }
    public static void thread1Even(){
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

    public static void thread2Odd(){
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