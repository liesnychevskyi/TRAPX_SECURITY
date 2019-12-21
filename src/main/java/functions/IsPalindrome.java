package functions;

import java.util.Scanner;

public class IsPalindrome
{

    public static void main(String args[])
    {
        IsPalindrome.is_palindrome_number(11);
        IsPalindrome.is_palindrome_string();
    }
    //-----------------------------------------------------------------------/For numbers function
    public static void is_palindrome_number(int number)
    {
        int r ,sum = 0, temp;
        temp = number;

        while(number > 0)
        {
            r = number % 10;  //getting remainder
            sum = (sum * 10) + r;
            number = number / 10;
        }
        if(temp == sum)
            System.out.println("palindrome number");
        else
            System.out.println("not palindrome");
    }
    //----------------------------------------------------------------------//For strings/numbers function
    public static void is_palindrome_string()
    {
        String original, reverse = "";  // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome:");
        original = in.nextLine();
        int length = original.length();
        for ( int i = length -1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse))
            System.out.println("Entered string/number is a palindrome.");
        else
            System.out.println("Entered string/number isn't a palindrome.");
    }
    //----------------------------------------------------------------------//
}

