import java.util.Scanner;

public class PigLatinConverterInput {
    public static String convertToPigLatin(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }

            // Check if the word starts with a vowel
            if (startsWithVowel(word)) {
                result.append(word).append("way");
            } else {
                // Find the index of the first vowel
                int firstVowelIndex = findFirstVowelIndex(word);

                // Move the consonants before the first vowel to the end and add "ay"
                String prefix = word.substring(0, firstVowelIndex);
                String suffix = word.substring(firstVowelIndex);
                result.append(suffix).append(prefix).append("ay");
            }
        }

        return result.toString();
    }

    private static boolean startsWithVowel(String word) {
        String lowerWord = word.toLowerCase();
        return lowerWord.startsWith("a") || lowerWord.startsWith("e") || lowerWord.startsWith("i")
                || lowerWord.startsWith("o") || lowerWord.startsWith("u");
    }

    private static int findFirstVowelIndex(String word) {
        String lowerWord = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char c = lowerWord.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return i;
            }
        }
        return -1; // No vowels found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence in English: ");
        String input = scanner.nextLine();

        String pigLatin = convertToPigLatin(input);
        System.out.println("Pig Latin: " + pigLatin);

        scanner.close();
    }
}