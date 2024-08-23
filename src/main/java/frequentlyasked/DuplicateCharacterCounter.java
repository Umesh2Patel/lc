package frequentlyasked;

//    Write a function which accepts a string and returns all characters which appear more than once along with their count.
//
//        Solution:


import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacterCounter {

    public static Map<Character, Integer> countDuplicateCharacters(String input) {
        // Create a HashMap to store characters and their counts
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Convert the input string to lowercase (optional) to consider case-insensitive duplicates
        input = input.toLowerCase();

        // Iterate through each character in the input string
        for (char ch : input.toCharArray()) {
            // Skip non-alphabetic characters (modify the condition as needed)
            if (!Character.isAlphabetic(ch)) {
                continue;
            }

            // Get the current count of the character (default to 0 if not found)
            int count = charCountMap.getOrDefault(ch, 0);

            // Increment the count for the current character
            charCountMap.put(ch, count + 1);
        }

        // Create a new HashMap to store characters that appear more than once
        Map<Character, Integer> result = new HashMap<>();

        // Iterate through the original HashMap and add characters with count > 1 to the result HashMap
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        Map<Character, Integer> duplicateCharacters = countDuplicateCharacters(input);

        // Print the characters and their counts that appear more than once
        for (Map.Entry<Character, Integer> entry : duplicateCharacters.entrySet()) {
            System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}
