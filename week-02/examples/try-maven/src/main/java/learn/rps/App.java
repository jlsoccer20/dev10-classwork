package learn.rps;
import com.github.javafaker.Faker;
public class App {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        System.out.println(fullName);

        String character = faker.pokemon().name();
        System.out.println(character);
    }
}
