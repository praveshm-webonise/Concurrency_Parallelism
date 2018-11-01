package dp;

class Philosopher extends Thread {
	final int sleeptime = 10000;
	private Fork fork_right;
	private Fork fork_left;
	private String name;

	Philosopher(Fork right, Fork left, String name) {
		this.fork_right = right;
		this.fork_left = left;
		this.name = name;
	}

	public void run() {

		try {
			System.out.println(name + "........thinking");
			sleep(sleeptime);
		} catch (InterruptedException ex) {
		}

		while (true) {
			eat();
		}
	}

	private void eat() {
		if (fork_right.take()) {
			if (fork_left.take()) {
				try {
					System.out.println(name + "is eating........");
					sleep(sleeptime);
				} catch (InterruptedException ex) {
				}
				System.out.println(name + "......put left fork");
				fork_left.putDown();
				System.out.println(name + "......put right fork");
				fork_right.putDown();

			} else {
				System.out.println(name + "......put right fork");
				fork_right.putDown();
			}
		}
	}
}
