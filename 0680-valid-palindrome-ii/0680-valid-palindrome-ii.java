class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return is_palindrome(left+1,right,s) || is_palindrome(left,right-1,s);
            }
        }
        return true;
    }
    private static boolean is_palindrome(int l,int r,String s){
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}