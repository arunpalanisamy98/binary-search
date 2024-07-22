package com.leetcode.contests;

public class Leetcode100339 {
    public static void main(String[] args) {
        String str = "dart"; 
        Leetcode100339 leetcode100339 = new Leetcode100339();
        System.out.println(leetcode100339.getEncryptedString(str, 3));;
    }

    public String getEncryptedString(String s, int k) {
        char arr[] = s.toCharArray();
        char arr1[] = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
            if(i+k>arr.length-1){
                int change = (i+k)-(arr.length-1);
                arr[i] = arr1[change];
            }else{
                arr[i]=arr1[i+k];
            }
        }
        return String.valueOf(arr);
    }

}
