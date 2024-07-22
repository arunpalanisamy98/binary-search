package com.leetcode;

import java.util.Arrays;

public class Leetcode1099 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        
        Leetcode1099 l1099 = new Leetcode1099();
        //System.out.println(l1099.bs(arr, -1, 0));
        System.out.println(l1099.twoSumLessThanK(arr, 9));
    }


    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        for(int i=0;i<nums.length-1; i++){
            int index = bs(nums, k-nums[i]-1, i+1);
            if(index>=0 && index<nums.length){
                //if(nums[i]+nums[index]==k-1) return k-1;
                ans = Integer.max(ans, nums[i]+nums[index]);
            }
            //if(index>=nums.length) index--;
        }
        return ans;
    }

    public int twoPointer(int[] arr, int k){
        int s = 0, e = arr.length-1, ans = Integer.MIN_VALUE;
        while(s<e){
            if(arr[s]+arr[e]<k-1){
                ans = Integer.max(ans, arr[s]+arr[e]);
                s++;
            }else if(arr[s]+arr[e]>k-1){
                e--;
            }else{
                return k-1;
            }
        }
        return ans;
    }

    public int bs(int nums[], int t, int s){
        int e = nums.length, m = 0;
        while(s<e){
            m = s + (e-s)/2;
            if(nums[m]==t) return m;

            if(nums[m]<t){
                s = m+1;
            }else{
                e = m-1;
            }
        }
        return s-1;
    }

    
}
