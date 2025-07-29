import java.util.Scanner;

public class F07_AnagramPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] freq = new int[26];  

        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[Character.toLowerCase(c) - 'a']++;
            }
        }

        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        if (oddCount <= 1) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}

