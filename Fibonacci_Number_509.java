class Solution {
    //Method 1: Recursive and simplest code
    //Time: Its a binary tree. So with every increment in n by 1, we have to do twice more computation than before. So O(2^n) time. 9ms(25.43%)
    //Space: Only 1 stack trace, so O(n) space. 40.2MB(39.62%)
    public int fib1(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fib(n-1) + fib(n-2);
    }
    
    //Method 2: Memoization of the repeated calculation using HashMap. Top Down
    // O(n) time. Improvement from O(2^n) by saving all the computations in hashmap. 0ms(100%)
    // O(n) space. Hashmap - O(n), fibCalc recursive stack - O(n). 40.7MB(8.98%)
    public int fib2(int n) {
        Map<Integer, Integer> fibMap = new HashMap<Integer, Integer>();
        fibMap.put(0,0);
        fibMap.put(1,1);
        return fibCalc(n, fibMap);
    }
    
    public int fibCalc(int n, Map<Integer, Integer> fibMap) {
        if(fibMap.containsKey(n)) {
            return fibMap.get(n);
        } else {
            fibMap.put(n, (fibCalc(n-1, fibMap) + fibCalc(n-2, fibMap)));
            return fibMap.get(n);
        }
    }
    
    //Method 3: Bottom Up memoization
    // O(n) time. Iterative calculation of fibonacci from 0 to n. No question of repetative calculation. So no optimization for it. 0ms(100%)
    // O(n) space. Storing all fibonacci from 0 to n, so that we can reference fib(i-1)+fib(i-2) as we keep computing. 40.3MB(29.06%)
    public int fib3(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int[] fibArr = new int[n+1];
        fibArr[0] = 0;
        fibArr[1] = 1;
        for(int i = 2; i <= n; i++) {
            fibArr[i] = fibArr[i-1] + fibArr[i-2];
        }
        return fibArr[n];
    }

    //Method 4: Pure iterative
    // O(n) time. Similar to above. Iterative calculation from 0 to n. 0ms(100%)
    // O(1) space. Above method saved all fib values when only last 2 are important for calculation. This optimizes on that. 40.1MB(70.02%)
    public int fib(int n) { //fib4
        int v0 = 0;
        int v1 = 1;
        int v2 = -1;
        if(n<2)
            return n;
        for(int i = 2; i <= n; i++) {
            v2 = v0 + v1;
            v0 = v1;
            v1 = v2;
        }
        return v2;
    }
    
    /*
    Method 5 - Binet's Nth-term Formula

    Using Binet's Formula for the Nth Fibonacci involves the usage of our golden section number Phi.
    Phi = ( sqrt(5) + 1 ) / 2
    Using approximation equation is good enough here, since we know N >= 0 && N <= 30, we can safely use the following rounded function
    Fib(N) = round( ( Phi^N ) / sqrt(5) )
    Full mathematical explanation of Binet's Formula here

    O(log n) time. 0ms(100%)
    O(1) space. 40.1MB(54.21%)
    */
     public int fib5(int n) {
         double phi = (Math.sqrt(5)+1)/2;
         return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }
    
    
}
