import java.util.Scanner;

class DisplayThread extends Thread {
    int number;
    String message;
    boolean checkEvenOdd;

    DisplayThread(int number) {
        this.number = number;
        this.message = null;
        this.checkEvenOdd = true;
    }

   
    DisplayThread(int number, String message) {
        this.number = number;
        this.message = message;
        this.checkEvenOdd = true;
    }

    public void run() {
        try {
           
            Thread.sleep(number);

           
            if (message != null) {
                System.out.println(Thread.currentThread().getName() + " says: " + message);
            }

           
            if (checkEvenOdd) {
                if (number % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + number + " is even");
                } else {
                    System.out.println(Thread.currentThread().getName() + ": " + number + " is odd");
                }
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number for Thread 1: ");
        int num1 = sc.nextInt();

     
        System.out.print("Enter number for Thread 2: ");
        int num2 = sc.nextInt();

        
        DisplayThread t1 = new DisplayThread(num1);
        t1.setName("Thread 1");

        DisplayThread t2 = new DisplayThread(num2, "Hello from Thread 2!"); 
        t2.setName("Thread 2");

        
        t1.start();
        t2.start();

        sc.close();
    }
}