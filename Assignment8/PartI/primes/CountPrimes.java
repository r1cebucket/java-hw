package primes;

import java.util.HashMap;

public class CountPrimes {
	static HashMap<Long, Boolean> isPrime = new HashMap<>();

	static boolean isPrime(long val) {
		if (isPrime.containsKey(val)) {
			return isPrime.get(val);
		}

		long upper_bound = (long) Math.floor(Math.sqrt(val));

		for (long i = 2; i <= upper_bound; i++) {
			if (val % i == 0) {
				isPrime.put(val, false);
				return false;
			}
		}
		isPrime.put(val, true);
		return true;
	}

	static int numPrimes(long from, long to) {
		int primeCount = 0;
		for (long i = from; i < to; i++) {
			if (isPrime(i)) {
				primeCount++;
			}
		}
		return primeCount;

	}
}
