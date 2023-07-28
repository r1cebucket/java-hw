package primes;

import java.util.HashSet;
import java.util.Set;

public class ThreadedCountPrimes implements Runnable {
	private long min;
	private long max;
	public static int total = 0;

	public ThreadedCountPrimes(long min, long max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void run() {
		int count = CountPrimes.numPrimes(min, max);
		synchronized (this) {
			ThreadedCountPrimes.total += count;
		}
	}

	public static void main(String[] args) {

		long min = 10_000_000;
		long max = 20_000_000;

		long startTime = System.currentTimeMillis();
		long numPrimes = CountPrimes.numPrimes(min, max);

		long endTime = System.currentTimeMillis();
		System.out.println("number of primes from " + min + " to " + max + " is " + numPrimes);
		System.out.println("this took  " + (endTime - startTime) + " ms ");
		// System.exit(0);

		/*
		 * you're going to start a bunch of threads, and you want them
		 * all to complete and get the total number of primes within
		 * the interval min, max when the threads are complete.
		 * 
		 * Figure this out. Specifically, figure out how to wait until
		 * a bunch of threads finish until continuing your code
		 */
		long[] intervals = { 1_000, 10_000, 100_000 };
		for (long interval : intervals) {
			ThreadedCountPrimes.total = 0;
			long intervalCount = (max - min) / interval;
			if ((max - min) % interval > 0) {
				intervalCount += 1;
			}
			Set<Thread> threadSet = new HashSet<Thread>();
			// Set<ThreadedCountPrimes> primesSet = new HashSet<ThreadedCountPrimes>();

			startTime = System.currentTimeMillis();

			for (int i = 0; i < intervalCount; i++) {
				long from = min + i * interval;
				long to = Math.min(max, from + interval);
				Thread t = new Thread(new ThreadedCountPrimes(from, to));
				threadSet.add(t);
				t.start();
			}

			for (Thread t : threadSet) {
				try {
					t.join();
				} catch (InterruptedException e) {
					System.out.println("Thread interrupted.");
				}
			}

			endTime = System.currentTimeMillis();
			System.out.println(
					"Threaded: number of primes from " + min + " to " + max + " is " + ThreadedCountPrimes.total);
			System.out.println("this took  " + (endTime - startTime) + " ms with the interval of " + interval);
		}
	}
}
