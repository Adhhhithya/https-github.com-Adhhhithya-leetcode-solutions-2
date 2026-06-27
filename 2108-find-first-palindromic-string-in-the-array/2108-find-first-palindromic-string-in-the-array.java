class Solution {
    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(is_palindrome(word)){
                return word;
            }
        }
        return "";
    }
    private static boolean is_palindrome(String str){
        int n = str.length();
        int l =0;
        int r = n-1;
        while(l<r){
            if(str.charAt(l)==str.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}