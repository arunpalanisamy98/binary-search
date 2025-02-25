/*
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in ascending order, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

You must write an algorithm that runs in logarithmic time.

 

Example 1:

Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

Example 2:

Input: citations = [1,2,100]
Output: 2

 */

package com.leetcode;
 

public class Leetcode275 {
    public static void main(String[] args) {
        int arr[] = { 0,1};
        Leetcode275 l275 = new Leetcode275();
        System.out.println(l275.hIndex(arr));
    }


    public int hIndex(int[] citations) {
        int s = 0, len = citations.length, e = len-1, m = 0;
        while (s<=e){
            m = s + (e-s)/2;
            if(citations[m]==len-m) return citations[m];

            if(citations[m]<len-m){
                s = m+1;
            }else{
                e = m-1;
            }
        }
        return len-s;
    }
     
 }