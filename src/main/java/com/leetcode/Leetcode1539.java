package com.leetcode;


public class Leetcode1539 {
    public static void main(String[] args) {
        Leetcode1539 l1539 = new Leetcode1539();
        int[] arr = {7,13,21,25,29,32,38,45};
        System.out.println(l1539.findKthPositive(arr, 4));
        

    }

    public int findKthPositive(int[] arr, int k){
        int s = 0, e = arr.length-1, m = 0;
        while(s<=e){
            m = s + (e-s)/2;

            if(arr[m]-m-1==k) return arr[m]-1;

            if(arr[m]-m-1>k){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        System.out.println("s,e: "+s+","+e);
        System.out.println(arr[s]+","+arr[e]);
        return arr[e]+(k-(arr[e]-e-1));
    }
}
