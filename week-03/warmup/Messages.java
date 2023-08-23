import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
public class Messages {

    public static void main(String[] args) {
        File file = new File("message.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("message.txt created.");
            } else {
                System.out.println("message.txt already exists.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //writeMessage("I love rainbows and unicorns. You Should too! :) ");
        readMessage("colors.txt");
    }

    public static void readMessage(String file) {
        try (FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader)){

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }
/*
        public static void writeMessage(String message){
            try (PrintWriter writer = new PrintWriter("message.txt");
                writer.println(message)){
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }



        }

 */
    }
}

