package September09;

public class CheckVowel {
    public static boolean isVowel(char ch) {
        char lowercaseChar = Character.toLowerCase(ch);
        return lowercaseChar == 'a' || lowercaseChar == 'e' || lowercaseChar == 'i' || lowercaseChar == 'o'
                || lowercaseChar == 'u';

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}
