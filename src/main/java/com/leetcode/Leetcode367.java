package com.leetcode;

public class Leetcode367{
    public static void main(String[] args) {
        Leetcode367 l367 = new Leetcode367();
        l367.isPerfectSquare(808201);
    }

    public boolean isPerfectSquare(int num){
        if(num==1) return true;
        long s = 1, e = num/2;
        while(s<=e){
            long m = s + (e-s)/2;
            if(m*m==num) return true;
            if(m*m>num) e = m-1;
            if(m*m<num) s = m+1;
        }
        return false;
    }
}