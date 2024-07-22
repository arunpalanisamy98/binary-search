package com.leetcode;

public class Leetcode852 {
    
    public int peakIndexInMountainArray(int[] arr) {
        
        int s = 0, m = 0, e = arr.length-1;
    
        while(s<e){
            m = s + (e-s)/2;
            if(arr[m]>arr[e]){
                s = m+1;
            }else if(arr[m]<arr[e]){
                e = m;
            }else{
                e = e-1;
            }
        }
        System.out.println("[s,e]: ["+s+","+e+"]");
        return s==0 ? arr.length-1 : s-1;
}
        //return e;
    }
    
