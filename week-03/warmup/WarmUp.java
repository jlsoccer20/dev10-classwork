public class WarmUp {
    public static void main(String[] args) {
        System.out.println(encode("cat", 3));
        System.out.println(decode("fdw", 3));
    }
    public static String encode(String value, int shift){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newWord = "";
        for (int i = 0; i < value.length();i++){
            for(int j = 0; j < alphabet.length(); j++){
                if(value.toLowerCase().charAt(i) == alphabet.toLowerCase().charAt(j)){
                    newWord = newWord + alphabet.charAt(j + shift);
                }
            }
        }
        return newWord;
    }

    public static String decode(String value, int unshift){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newWord = "";
        for (int i = 0; i < value.length();i++){
            for(int j = 0; j < alphabet.length(); j++){
                if(value.toLowerCase().charAt(i) == alphabet.toLowerCase().charAt(j)){
                    newWord += alphabet.charAt(j - unshift);
                }
            }
        }
        return newWord;
    }
}
