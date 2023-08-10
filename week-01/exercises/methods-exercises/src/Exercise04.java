

public class Exercise04 {

    public static void main(String[] args) {
        System.out.println(getFirstVowel("magnificent")); // Expected: a
        System.out.println(getFirstVowel("winsome")); // Expected: i
        System.out.println(getFirstVowel("xxx")); // Expected:

        // 2. Call getFirstVowel at least one more time.
        System.out.println(getFirstVowel("jessica")); // Expected: e
    }

    // getFirstVowel returns the first vowel in a string as a char.
    // 1. Complete getFirstVowel.
    // If no vowel is found, return 0. (As a char, 0 represents the NULL value.)
    public static char getFirstVowel(String value) {

        String vowels = "aeiou";
        String loweredWord = value.toLowerCase();

        for (int index = 0; index < loweredWord.length(); index++){
            char c = loweredWord.charAt(index);
            if (vowels.contains(String.valueOf(c))){
                return c;
            }
        }

        // handle cases where a vowel is not found
        return 0;
/*
        // Kachew
        if (value.isEmpty())
            return 0;
        int index = 0;
        do{
            char c = value.charAt(index);
            index++;

            switch(c){
                case "a":
                    return "a";
                case "e":
                    return "e";
                case "i":
                    return "i";
                case "o":
                    return "o";
                case "u":
                    return "u";
            }
        } while {
        }
        */

    // check for vowels
    //if (value.isEmpty()){
    //    return 0;

    }
    //return value.charAt(0);
}


//String vowels = "aeiou";
//        return vowels.charAt(index)