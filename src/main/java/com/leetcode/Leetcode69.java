package com.leetcode;

public class Leetcode69 {
    public static void main(String[] args) {
        Leetcode69 l69 = new Leetcode69();
        //Math.sqrt(10);
        System.out.println(l69.mySqrt(4));
    }

    public int mySqrt(int x){
        long s = 1, e = x/2, ans = 0, m = 0;
        while(s<=e){
            m = s + (e-s)/2;
            ans = m*m;
            if(ans==x) return (int)m;
            if(ans<x) s = m+1;
            if(ans>x) e = m-1;
        }
        return (int) e;
    }
}
