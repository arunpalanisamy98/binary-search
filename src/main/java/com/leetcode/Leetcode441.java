package com.leetcode;

public class Leetcode441 {
    public static void main(String[] args) {
        Leetcode441 l441 = new Leetcode441();
        System.out.println(l441.arrangeCoins(3));
    }

    public int arrangeCoins(int n) {
        if(n==1) return 1;
        if(n==3) return 2;
        long s = 1, e = n/2, ans = 0, m = 0;
        while(s<=e){
            m = s + (e-s)/2;
            ans = (m*(m+1))/2;
            if(ans>n) e = m-1;
            if(ans<n) s = m+1;
            if(ans==n) return (int) m;
        }
        return (int)e;
    }


}
