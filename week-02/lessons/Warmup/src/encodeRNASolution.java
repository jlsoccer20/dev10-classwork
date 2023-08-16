public class encodeRNASolution {

    public static void replaceString (String input){
        //String output = "";
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            switch(input.charAt(i)){
                case 'a':
                    output.append('u');
                    break;
                case 'u':
                    output.append('a');
                    break;
                case 'g':
                    output.append('c');
                    break;
                case 'c':
                    output.append('g');
                    break;
                default:
                    break;

            }
        }
        System.out.printf("\"%s\" -> \"%s\"%n", input, output);
    }

    public static void main(String[] args) {
        replaceString("aacg");
        replaceString("acgu");
    }
}
