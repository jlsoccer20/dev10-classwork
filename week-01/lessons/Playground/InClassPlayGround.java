public class InClassPlayGround {

    public static void main(String[] args) {

        //Primitive Data types

        // float - shorter decimal values 1.5
        float myFloat1 = 1.5f;
        float myFloat2 = 1.5F;

        // double - has more storage space
        double myDouble = 1.5;

        // int up to 2147483647
        int i = 2147483647;
        long biggerInt = (long) i + 1;
        System.out.println(biggerInt);


        // long - big numbers
        long l = 123456;

        // boolean

        // byte

        // char

        // short

        // Reference types
        // String?
        String hello = "Hello World";
        String hello2 = new String("Hello World");
        System.out.println(hello.equals(hello2));
        String h3 = hello;

        long roundedDouble = Math.round(myDouble);

        hello.concat( " it's me, Jessica!");

    }
}
