/*
 Name:Ashwin Shiv
 Roll No:181210013
 CSE 2nd Year
 */
public class MyThreadProject {

	public static void main(String[] args) {
//		MyObject myObject = new MyObject();
//		System.out.println("Consumer - Producer started WITHOUT SYNC");
//		MyThreadProject.createProducerThread(myObject).start();
//		MyThreadProject.createConsumerThread(myObject).start();

		MyObject mySYNCObject = new MyObject();
		System.out.println("Consumer - Producer started WITH SYNC");
		MyThreadProject.createProducerThreadSYNC(mySYNCObject).start();
		MyThreadProject.createConsumerThreadSYNC(mySYNCObject).start();
		MyThreadProject.createConsumerThreadSYNC1(mySYNCObject).start();

	}

	public static Thread createProducerThread(MyObject threadque) {
		Thread producerThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Producer thread started...");
				for (int i = 1; i <= 600; ++i) {
					threadque.putDataInQueue("Ashwin message " + i);
//	              System.out.println("Put message " + i);
				}
			}
		};

		return producerThread;
	}

	public static Thread createConsumerThread(MyObject threadque) {
		Thread consumerThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Consumer 1 thread started...");
				for (int i = 1; i <= 600; ++i) {
					try {
						threadque.removeDataFromQueue();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
//	              System.out.println("Put message " + i);
				}
			}
		};

		return consumerThread;
	}

	public static Thread createProducerThreadSYNC(MyObject threadque) {
		Thread producerThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Producer SYNC thread started...");
				for (int i = 1; i <= 600; ++i) {
					try {
						threadque.putDataInQueueSYNC("Ashwin message " + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//	              System.out.println("Put message " + i);
				}
			}
		};

		return producerThread;
	}

	public static Thread createConsumerThreadSYNC(MyObject threadque) {
		Thread consumerThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Consumer SYNC thread 1 started...");
				for (int i = 1; i <= 600; ++i) {
					try {
						threadque.removeDataFromQueueSYNC();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
//	              System.out.println("Put message " + i);
				}
			}
		};

		return consumerThread;
	}

	public static Thread createConsumerThreadSYNC1(MyObject threadque) {
		Thread consumerThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Consumer SYNC thread  2 started...");
				for (int i = 1; i <= 600; ++i) {
					try {
						threadque.removeDataFromQueueSYNC();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
//	              System.out.println("Put message " + i);
				}
			}
		};

		return consumerThread;
	}

}
