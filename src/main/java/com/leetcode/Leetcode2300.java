package com.leetcode;

import java.util.Arrays;

public class Leetcode2300 {
    public static void main(String[] args) {
        Leetcode2300 l2300 = new Leetcode2300();
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        Arrays.stream(l2300.successfulPairs(spells, potions, 7))
        .forEach(System.out::println);
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int ans[] = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++){
            if(success<=spells[i]){
                ans[i] = potions.length;
                continue;
            }
            long invariant = 0;

            if(success % (long) spells[i]==0){
                invariant = success;
            }else{
                invariant = success + ((long) spells[i]-(success % (long) spells[i]));
            }
            

            int index = bs(potions,invariant/spells[i]);
            if(index == -1 || index==potions.length){
                ans[i] = 0;
                continue;
            }else{
                ans[i] = potions.length-index;
            }

            
        }
        return ans;
    }

    public int bs(int arr[], long t){
        int s = 0, e = arr.length-1, m =0, result = Integer.MIN_VALUE;
        while(s<=e){
            m = s + (e-s)/2;
            if(arr[m]==t){
                result = m;
                e = m-1;
            }else if(arr[m]>t){
                e = m-1;
            }else{
                s = m +1;
            }
        }

        return result==Integer.MIN_VALUE ? s : result;
    }


    
}
