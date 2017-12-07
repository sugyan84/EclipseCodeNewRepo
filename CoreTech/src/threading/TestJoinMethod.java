package threading;


class MyRunnable implements Runnable{
    public void run(){
        System.out.println("in run() method");
           for(int i=0;i<5;i++){
                  System.out.println("i="+i+" ,ThreadName="+Thread.currentThread().getName());
           }          
    }
}
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class TestJoinMethod {
    public static void main(String...args) throws InterruptedException{
           System.out.println("In main() method");
           MyRunnable runnable=new MyRunnable();
           Thread thread1=new Thread(runnable);
           Thread thread2=new Thread(runnable);

           thread1.start();
           thread1.join();

           thread2.start();
          // thread2.join();

           
           thread2.join();
           
           for(int i=0;i<5;i++)System.out.println("Chutiya "+i);
           
        
           
           System.out.println("end main() method");
    }
}