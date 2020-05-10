
/*
 Name:Ashwin Shiv
 Roll No:181210013
 CSE 2nd Year
 */
import java.util.concurrent.LinkedBlockingQueue;

public class MyObject {

	private LinkedBlockingQueue sharedqueue;

	public MyObject() {
		sharedqueue = new LinkedBlockingQueue(10);

	}

	public boolean isEmpty() {
		return sharedqueue.isEmpty();
	}

	public boolean isFull() {
		if (sharedqueue.size() == 10) {
			return true;
		}
		return false;

	}

	public void putDataInQueue(String s) {
		if (!isFull()) {
			sharedqueue.add(s);
			System.out.println("Put added to QUE " + s);
		} else {
			System.out.println("Queue is full.");
			System.out.println("MESSAGE NOT ADDED " + s);
		}

	}

	public void removeDataFromQueue() throws InterruptedException {
		if (isEmpty()) {
			System.out.println("Cannot dequeue it.It is empty.");
		} else {
			System.out.println("Message removed from the QUE " + sharedqueue.take());
		}
	}

	public synchronized void removeDataFromQueueSYNC() throws InterruptedException {
		if (isEmpty()) {
			// System.out.println("Cannot dequeue it.It is empty.");
			wait();
		} else {
			System.out.println("Message removed from the QUE " + sharedqueue.take());
			notifyAll();
		}
	}

	public synchronized void putDataInQueueSYNC(String s) throws InterruptedException {
		if (!isFull()) {
			sharedqueue.add(s);
			System.out.println("Put added to QUE " + s);
			notifyAll();
		} else {
			wait();
//			System.out.println("Queue is full.");
//			System.out.println("MESSAGE NOT ADDED " + s);
		}

	}

	public void print() {
		System.out.println("Queue " + sharedqueue);

	}

}
