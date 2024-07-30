class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        char[] sarr = s.toCharArray();
        while(left <= right){
            while(left < right && !Character.isLetterOrDigit(sarr[left])) left++;
            while(left < right && !Character.isLetterOrDigit(sarr[right])) right--;

            if(Character.toLowerCase(sarr[left]) != Character.toLowerCase(sarr[right])) return false;
            left++;right--;
        }

        return true;
    }
}