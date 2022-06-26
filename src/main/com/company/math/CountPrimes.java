package com.company.math;

/**
 * Count Primes
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
 *
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 5 * 106
 *
 * Explanation:
 * Sieve of Eratosthenes algorithm. (See: Sieve_of_Eratosthenes.gif)
 * Create array of n and assume all are primes by default.
 * Iterate from i=2 to i*i<n mark all from j=i*i to n with step i as not primes.
 * Iterate array once more to count prime numbers.
 *
 * Time complexity : O(n * log(log(n))).
 * Space complexity : O(n).
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes app = new CountPrimes();
        System.out.println(app.countPrimes(10)); // 4
        System.out.println(app.countPrimes(120)); // 30
        System.out.println(app.countPrimes(0)); // 0
        System.out.println(app.countPrimes(1)); // 0
    }

    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] notPrime = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (notPrime[i]) continue;
            for (int j = i * i; j < n ; j += i) {
                notPrime[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) count++;
        }
        return count;
    }

    public int countPrimesBruteForce(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
