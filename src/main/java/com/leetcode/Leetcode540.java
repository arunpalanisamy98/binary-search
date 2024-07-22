package com.leetcode;

public class Leetcode540 {
    public static void main(String[] args) {
        Leetcode540 l540 = new Leetcode540();
        int arr[] = {0,0,1,1,3};
        System.out.println(l540.singleNonDuplicate(arr));
    }

    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int s = 0, len = nums.length, e= len-1, m = 0;
        while(s<=e){
            m = s + (e-s)/2;
            if(m==0){
                if(nums[m]==nums[m+1]){
                    s = m+2;
                }else{
                    return nums[m];
                }
            }
            if(m==len-1){
                if(nums[m]==nums[m-1]){
                    e = m-2;
                }else{
                    return nums[m];
                }
            }

            if(nums[m]==nums[m+1]){
                //m+1 should be odd
                if((m+1)%2==1){
                    s = m+2;
                }else{
                    e = m-1;
                }

            }else if(nums[m]==nums[m-1]){
                // m should be odd
                if(m%2==1){
                    s = m +1;
                }else{
                    e = m-2;
                }
            }else{
                return nums[m];
            }
        }
        return 0;
    }
}
