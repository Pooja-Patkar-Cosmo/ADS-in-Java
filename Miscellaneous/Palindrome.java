import java.util.Scanner;

public class Palindrome {
    static int count = 0;

    static boolean isPalindrome(String s, int left, int right) {
        count++;
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        boolean result = isPalindrome(str, 0, str.length() - 1);
        if (result) {
            System.out.println("\"" + str + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a Palindrome.");
        }
        System.out.println("Recursive calls (iterations): " + count);
        sc.close();
    }
}     
    

