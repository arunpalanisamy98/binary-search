package com.leetcode;
/**
 * just a daily challenge 
 */
public class Leetcode28 {
    public static void main(String[] args) {
        Leetcode28 l28 = new Leetcode28();
        String haystack = "mississippi", needle = "issip";
        System.out.println(l28.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        char hay[] = haystack.toCharArray();
        char ans[] = needle.toCharArray();
        int a = 0, h = 0;
        while(a<ans.length&&h<hay.length){
            if(hay[h]==ans[0]&&check(hay, ans, h)){
                    return h;
            }else{
                h++;
                a=0;
            }
        }
        return -1;
    }

    public boolean check(char[] hay, char[] ans, int h){
        int  a = 0;
        while(h<hay.length && a<ans.length){
            if(hay[h]==ans[a]){
                h++;
                a++;
            }else{
                return false;
            }
        }
        if(a<ans.length){
            return false;
        }
        return true;
    }
}
