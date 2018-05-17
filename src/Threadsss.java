public class Threadsss {
    Object obj1 = new Object();
    Thread obj2 = new Thread();
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on " + obj1);
        synchronized (obj1) {
            System.out.println(name + " acquired lock on " + obj1);
            work();
        }
        System.out.println(name + " released lock on " + obj1);
        System.out.println(name + " acquiring lock on " + obj2);
        synchronized (obj2) {
            System.out.println(name + " acquired lock on " + obj2);
            work();
        }
        System.out.println(name + " released lock on " + obj2);

        System.out.println(name + " finished execution.");
    }

    private void work() {
        System.out.println("get Kitty breakfast and I am :" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Threadsss threadsss = new Threadsss();
        threadsss.run();
    }
}

