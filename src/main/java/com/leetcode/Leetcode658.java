package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode658 {
    public static void main(String[] args) {
        int arr[] = {1,1,1,10,10,10};
        Leetcode658 l658 = new Leetcode658();
        l658.findClosestElements(arr,1,9).stream().forEach(System.out::println);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = bs(arr,x);
        System.out.println("pos: "+pos);
        List<Integer> ans = new ArrayList<Integer>();
        if(pos>arr.length-1){
            for(int i = pos-k; i<= arr.length-1; i++){
                ans.add(arr[i]);
            }
            return ans;
        }

        if(pos<=0){
            for(int i = 0; i<k; i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        
        //ans.add(arr[pos]);
        int ptr1 = pos-1, ptr2 = pos, count = 0;

        while(ptr1 >= 0 && ptr2<arr.length && count<k){
            if(Math.abs(x-arr[ptr1]) < Math.abs(arr[ptr2] - x)){
                ans.add(0,arr[ptr1]);
                ptr1--;
            }else if(Math.abs(arr[ptr1]-x) > Math.abs(arr[ptr2] - x)){
                ans.add(ans.size(),arr[ptr2]);
                ptr2++;
            }else{
                if(arr[ptr1]<arr[ptr2]){
                    ans.add(0,arr[ptr1]);
                    ptr1--;
                }else{
                    ans.add(ans.size(),arr[ptr2]);
                    ptr2++;
                }
            }
            count++;
        }

        if(count!=k){
            if(ptr1>0){
                while(ptr1>=0 && count!=k){
                    ans.add(0,arr[ptr1]);
                    count++;
                    ptr1--;
                }
            }
            if(ptr2<=arr.length-1){
                while(count!=k && ptr2<=arr.length-1){
                    ans.add(ans.size(),arr[ptr2]);
                    count++;
                    ptr2++;
                }
            }
            
        }
        System.out.println("ptr1: "+ptr1);
        System.out.println("ptr2: "+ptr2);

        //Collections.sort(ans);
        
        
        
        return ans;
    }


     public int bs(int arr[], int t){
        int s = 0, e = arr.length-1, m = 0;
        while(s<=e){
            m = s + (e-s)/2;
            if(arr[m]==t){
                return m;
            }else if(arr[m]>t){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        Math.abs(s);
        return s;
    }
}
