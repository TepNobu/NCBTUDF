package wl.ncb.tudf.test;

public class HelloRunnable {

	public HelloRunnable() {
		// TODO Auto-generated constructor stub
	}
	 public static void main(String[] args)  {
		 Thread t2 = new Thread(() -> {System.out.println("My Runnable..2");});
		 t2.start();
		 Thread t1 = new Thread(() -> {System.out.println("My Runnable1..");});
		 t1.start();
		 
	    }
}
