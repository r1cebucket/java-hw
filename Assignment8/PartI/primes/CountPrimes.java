package primes;

public class CountPrimes {

	static boolean isPrime(long val) {
        long upper_bound = (long) Math.floor(Math.sqrt(val));
        
        for (long i = 2; i <= upper_bound; i++) {
            if (val % i == 0)
                return false;
        }
        
        return true;		
	}
	
	static int numPrimes(long from, long to) {
		int primeCount = 0;
		for (long i = from ; i <= to; i++) {
			if (isPrime(i)) {
				primeCount++;
			}
		}
		return primeCount;
		
	}
}
