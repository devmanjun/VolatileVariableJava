package root;

import java.lang.Thread;
import java.util.Calendar;

public class VolatileSample {
	private static volatile int myInt = 0;//Volatile Variable

	public static void main(String[] args) {
		startThreads();

	}

	/**
	 * Two threads are called simultaneously
	 * Both threads show log values based on Value of volatile variable
	 */
	private static void startThreads() {

		Calendar calendarInstance=Calendar.getInstance();
		new Thread1(calendarInstance).start();
		new Thread2().start();

	}

	/**
	 * 
	 * @author User
	 *Thread! simply shows the value of myInt and current time
	 */
	static class Thread1 extends Thread {
		
		Calendar cInstance;
		public Thread1(Calendar calendarInstance) {
			cInstance=calendarInstance;
		}

		public void run() {
			while (myInt < 5) {
				System.out.println(cInstance.getTimeInMillis()+"  MY_INT ->"+myInt);
			}
		}

	}

	/**
	 * 
	 * @author User
	 *
	 *Thread2 increments the valuye of myInt and displays the value
	 *Once Thread2 increments value to 5, Thread 1 will not display any values
	 */
	static class Thread2 extends Thread {
		public void run() {
			while (myInt++ < 10) {
				System.out.println("Thread 2 -> MY_INT = " + myInt);
			}
		}
	}

}
