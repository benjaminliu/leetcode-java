package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/14.
 */
public class _204_CountPrimes {
    public int countPrimes(int n) {
        n--;
        if (n < 2) return 0;
        if (n < 3) return 1;
        if (n < 4) return 2;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        boolean isPrime;
        for (int i = 4; i <= n; i++) {
            isPrime = true;
            for (int j : primes) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes.size();
    }

    public int countPrimes1(int n) {
        if (n < 3)
            return 0;

        boolean[] f = new boolean[n];
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;

            for (int j = i * 3; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (isPrime[i] == true) {
                for (int j = 2; j * i < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
