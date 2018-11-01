package dp;

import java.util.concurrent.Semaphore;

class Fork {
	int limit = 1;
	public Semaphore fork = new Semaphore(limit);
	public int id;

	Fork(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public boolean take() {
		return fork.tryAcquire();
	}

	public void putDown() {
		fork.release();
	}
}