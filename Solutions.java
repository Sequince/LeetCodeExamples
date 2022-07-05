//Code Solutions:
//	- https://leetcode.com/problemset/all/?sorting=W3sic29ydE9yZGVyIjoiQVNDRU5ESU5HIiwib3JkZXJCeSI6IkRJRkZJQ1VMVFkifV0%3D

//FizzBuzz	-	https://leetcode.com/problems/fizz-buzz/
class Solution {
    public List<String> fizzBuzz(int n) {

        //New array to hold end value for return statement
        List<String> result = new ArrayList<>();
        
        //Might be faster in a case statement?
        //Loop through each item and add corresponding value to return variable
        //FizzBuzz check first so avoid adding Fizz or Buzz too early
        for(int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
            {
                result.add("FizzBuzz");
            }
            else if (i % 3 == 0)
            {
                result.add("Fizz");
            }
            else if (i % 5 == 0)
            {
                result.add("Buzz");
            }
            else
            {
                /*
                String s = String.valueOf(i);
                result.add(s);
                */
                
                result.add(Integer.toString(i));
            }
        }
          
        return result;
    }
}


//Two Sum	-	https://leetcode.com/problems/two-sum/submissions/
//We want 2 pointers to cycle through the integers
//checking until we find ones that will equal the target
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //Declare return variable outside for loop so can be used in return statement
        int[] result = new int[2];
        
        //Use i to point to first number for comparison
        for(int i = 0; i < nums.length; i++)
        {
            //Use j to point to second number for comparison
            for(int j = i+1; j <nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
        
    }
}



//Palindrome	-	https://leetcode.com/problems/palindrome-number/submissions/
//return true if palindrome or false if not
class Solution {
    public boolean isPalindrome(int x) {
        
        //Reversed version of number passed in
        int reversedNum = 0;
        //Temp copy of passed in value, used to retrieve last digit
        int tempNum = x;
        //Current last digit of tempNum
        int lastDigit = 0;

        
        while (tempNum > 0)
        {
            //Get the last digit by dividing by modulo operator
            lastDigit = tempNum % 10;

            //Store last digit in reversedNumber
            reversedNum = reversedNum * 10 + lastDigit;

            //Remove the last digit from tempNum
            tempNum = tempNum / 10;
        }
        
        if (reversedNum == x)
        {
            return true;
        }
        else
        {
            return false;
        }
     }
}



//Roman to Integer	-	https://leetcode.com/problems/roman-to-integer/submissions/
class Solution {
    public int romanToInt(String s) {
        
        //Declare object variable the size of string passed in
        int[] nums = new int[s.length()];

        //Loop through passed in string and set numeric values in 'Nums' object to be summed at bottom
        for (int i = 0; i<s.length(); i++) {
            
            switch (s.charAt(i)) {                
            case 'M':
                nums[i] = 1000;
                break;
                
            case 'D':
                nums[i] = 500;
                break;
                
            case 'C':
                nums[i] = 100;
                break;
                
            case 'L':
                nums[i] = 50;
                break;
                
            case 'X':
                nums[i] = 10;
                break;
                
            case 'V':
                nums[i] = 5;
                break;
                
            case 'I':
                nums[i] = 1;
                break;
            }
        }
        
        //Roman Numerals ALWAYS have highest value on left, if it doesn't you need to minus current value from sum
        int sum = 0;
        for (int j = 0; j<s.length()-1; j++) {
            if(nums[j]<nums[j+1]){
                sum -= nums[j];
            }
            else {
                sum += nums[j];
            }
        }
        
        //Add the final number to sum and return
        return sum+nums[nums.length-1];
    }
}



//Roman to Integer	-	https://leetcode.com/problems/longest-common-prefix/submissions/
class Solution {
    public String longestCommonPrefix(String[] strs) {

        //using i to loop through each character in first prefix passed in
        for (int i = 0; i < strs[0].length(); i++) {
            
            //tempChar holds single character for comparison from first previx passed in
            char tempChar = strs[0].charAt(i);
            
            //using j to iterate through each prefix one char at a time(i), checking if NOT same as target i variable
            for (int j = 0; j < strs.length; j++) {
                
                if (strs[j].length() == i || strs[j].charAt(i) != tempChar)
                {
                    //If end of a prefix reached or not same found, return valid string
                    return strs[0].substring(0,i);
                }
            }
        }        
        return strs[0];

        //System.out.printf("Length of object is: " + strs.length);
        //System.out.printf("Length of first item in object is: " + strs[0].length());
         //System.out.printf("SubStr value is: " + strs[0].substring(0,2));
    }
}



//Valid Parentheses	-	https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
     
        Stack<Character> stack = new Stack<Character>();
        
        //Iterate through each parentheses character until end is reached
        for(int i = 0; i < s.length(); i++) {
            
            //Declares target parentheses
            char c = s.charAt(i);
            
            //Check if an open parentheses, if not, check if empty or 
            // if it does NOT match item in the stack and return false
            switch(c) {
                case '(' :
                    stack.push(')');
                    break;
                case '{' :
                    stack.push('}');
                    break;
                case '[' :
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop())
                    {
                        return false;
                    }
                }
        }
        return stack.isEmpty();
    }
}



//Merge Two Sorted Lists	-	https://leetcode.com/problems/merge-two-sorted-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        //Return an empty result if lists are empty, or only one list is populated
        if(list1 == null) return list2;
        else if(list2 == null) return list1;
        
        //Both point to the same list, 
        //but dummy will always point to the starting point of the list (like a bookmark),
        //curr populates the list, return dummy+1 position at the end
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        //Confirm lowest number, add to curr list, increase list pointer position
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        //Ternary operator - If list1 is null(no values left), use list2, else just use list1.
        curr.next = list1 == null ? list2 : list1;
        
        //If lists may not be the same length, we can add 'if list1 != null ... same as above (and same for list 2)'
        
        //System.out.printf("Value is: " + list1.val);
        //System.out.println("Curr is: " + curr.val);
        //System.out.printf("Dummy is: " + dummy.next);
        
        
        //return list using dummy pointing to starting point of list
        return dummy.next;
    }
}



//Remove Duplicates from Sorted Array	-	https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        
        //If only one number in list, return
        int n = nums.length;
        if(n<=1) {return n;}
        
        int left = 0;
        int right = 1;
        
        //If right pointer == left pointer, increment right pointer, 
        //else set value in 'left' and increment both values until
        //reached end of n
        while(right <=n-1) {
            if(nums[right] == nums[left]) {
                right++;
            }
            else {
                nums[left+1] = nums[right];
                left++;
                right++;
            }
        }
        
        //zero index based, so add 1 to total and return
        return left+1;
        
    }
}