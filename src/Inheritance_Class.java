

class ThreadInherit extends Helper implements Runnable
{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            for (int i = 1; i <= 2; i++) {
                System.out.println("Hello World");
                Thread.sleep(50);
                if (i == 2) {
                    Notify();
                    Wait();
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Thread_Inherit1 extends ThreadInherit
{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Wait();
            for(int i = 1; i<=2; i++)
            {
                System.out.println("Welcome");
                Thread.sleep(55);
            }
            Notify();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Helper
{
    public synchronized void Wait() throws InterruptedException
    {
        wait();
    }
    public synchronized void Notify() throws InterruptedException
    {
        notify();
    }
}
public class Inheritance_Class {

    public static void main (String[] args)
    {
        Thread_Inherit1 u = new Thread_Inherit1();
        ThreadInherit t = new ThreadInherit();
        t.run();
        u.run();

    }

}
