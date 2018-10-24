package dp;

class Philosopher extends Thread {

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
			sleep(10000);
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
					sleep(10000);
				} catch (InterruptedException ex) {
				}
				fork_left.putDown();
				System.out.println(name + "......put left fork");
				fork_right.putDown();
				System.out.println(name + "......put right fork");

			} /*else {
				fork_right.putDown();
				System.out.println(name + "......put right fork");
			}*/
		}
	}
}
