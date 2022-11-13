import java.util.Scanner;

public class Palindrome1259 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                return;
            }
            if (isPalindrome(n)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }

    private static boolean isPalindrome(int n) {

        boolean result = false;

        // 1. 정수를 문자열로 바꿈
        String str = String.valueOf(n);
        // 2. 거꾸로 뒤집어봄
        StringBuilder newStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr.append(str.charAt(i));
        }
        // 3. 원래 값과 같으면 팰린드롬 수
        if (newStr.toString().equals(str)) {
            result = true;
        }
        return result;


    }


}
