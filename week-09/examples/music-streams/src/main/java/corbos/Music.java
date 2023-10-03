package corbos;

import java.lang.reflect.ParameterizedType;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Music {

    static void printName(Artist a){

    }
    public static void main(String[] args) {

        DataStore dataStore = new DataStore();

        Consumer<Artist> artistConsumer = (artist) -> {
            System.out.println(artist);
        };

        dataStore.getArtists().stream()
                .forEach(System.out::println);

        Music::printName;
        System.out::println;


        // lists all
        /*
        for (Artist a: dataStore.getArtists()){
            System.out.println(a);
        }

        Stream<Artist> artistStream = dataStore.getArtists().stream();
        artistStream = artistStream.filter(a -> a.getName().startsWith("A"));
        artistStream = artistStream.filter(a -> a.getTracks().size() > 2);
        //artistStream = artistStream.filter(a -> a.getName().contains("ack"));
        artistStream = artistStream.sorted();

        //materializing the stream
        artistStream.forEach(System.out::println); // passing a method reference to the stream, printing it out
        // findFirst()
        // findAny()
        // collect()
        // forEach()

        // 1. filter
        // 2. sort/order
        // 3. transform/map/project (projecting) map different items to different data types to jsx
        // 4. aggregate/group (SQL aggregation), can also do aggregation in streams API
           */
    }


}

