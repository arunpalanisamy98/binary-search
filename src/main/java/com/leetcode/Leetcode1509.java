package com.leetcode;

import java.util.Arrays;

public class Leetcode1509 {

    public static void main(String[] args) {
        Leetcode1509 l1509 = new Leetcode1509();
        int[] arr = {6,6,0,1,1,4,6};
        //l1509.mergeSort(arr, 0, arr.length);
        System.out.println("before sortig");
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("ans: "+l1509.minDifference(arr));
    }

    public int minDifference(int[] nums) {
        if(nums.length<=4){
            return 0;
        }
        mergeSort(nums, 0, nums.length);
        System.out.println("after sortig");
        Arrays.stream(nums).forEach(System.out::println);
        int left = 0, right = nums.length-4, min = Integer.MAX_VALUE;

        while(left<4&&right<nums.length){
            min = Integer.min(min, nums[right]-nums[left]);
            left++;
            right++;
        }

        
        
        return min;
    }

    public void mergeSort(int[] nums, int s, int e){
        if(e-s==1) return;
        int m = s + (e-s)/2;
        mergeSort(nums, s, m);
        mergeSort(nums, m, e);
        merge(nums,s,m,e);
    }

    public void merge(int[] nums, int s, int m, int e){
        int[] mixer = new int[e-s];
        int pos1 = s, pos2 = m, k = 0;
        while(pos1<m&&pos2<e){
            if(nums[pos1]<=nums[pos2]){
                mixer[k]=nums[pos1];
                pos1++;
                k++;
            }else{
                mixer[k]=nums[pos2];
                pos2++;
                k++;
            }
        }

        if(pos1<m){
            while(pos1<m){
                mixer[k]=nums[pos1];
                k++;
                pos1++;
            }
        }

        if(pos2<e){
            while(pos2<e){
                mixer[k]=nums[pos2];
                k++;
                pos2++;
            }
        }

        for(int i = 0; i<k && s<e; i++){
            nums[s] = mixer[i];
            s++;
        }
    }


}