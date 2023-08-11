public class Exercise10 {

    // 1. Add a `main` method.

    public static void main(String[] args){
        System.out.println(removeWhiteSpace("Hello blabla "));
        System.out.println(removeWhiteSpace("Hello      sadfa \t asdfd \n"));
        System.out.println(removeWhiteSpace("adf \r adf \t"));

    }
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.

    public static String removeWhiteSpace(String input){
        // Initialize a result String
        String result = "";
        // Identify whitespace - Character .isWhitespace

        // Iterate through string
        for (int i = 0; i < input.length(); i++){
            // Grab the char
            char letter = input.charAt(i);
            // If the character is not whitespace
            if (!Character.isWhitespace(letter)){
                // Add it to a result string
                result += letter;
            }
        } return result;
    }
}
