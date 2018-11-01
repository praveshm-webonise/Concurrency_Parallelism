package dp;

public class DiningPhilosopher {
	public static void main(String[] args) {

		String[] names = { "Philosopher1", "Philosopher2", "Philosopher3", "Philosopher4", "Philosopher5" };
		final int fork_limit = 5;
		final int philosopher_limit = 5;
		Fork[] fork = new Fork[fork_limit];
		Philosopher[] philosopher = new Philosopher[philosopher_limit];
		int fork_length = fork.length;
		for (int count = 0; count < fork_length; count++) {
			fork[count] = new Fork(count);
		}
		int philosopher_length = philosopher.length;

		for (int count = 0; count < philosopher_length; count++) {

			if (count != philosopher_length - 1) {
				philosopher[count] = new Philosopher(fork[count], fork[count + 1], names[count]);
				philosopher[count].start();
			} else {
				philosopher[count] = new Philosopher(fork[0], fork[count], names[count]);
				philosopher[count].start();
			}

		}
	}
}
