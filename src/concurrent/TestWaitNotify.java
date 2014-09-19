package concurrent;

public class TestWaitNotify {
	public static void main(String[] args) throws Exception {
		Thread myThread = new MyThread();
		myThread.start();

		synchronized (myThread) {
			myThread.wait();
		}

		System.out.println("wait����.");
	}

	static class MyThread extends Thread {
		public void run() {
			System.out.println(getName() + "��ʼsleep");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "����sleep");
		}
	}
}
