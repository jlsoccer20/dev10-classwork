public class App {
    public static void main(String[] args){

        /*
        Point to a reference

         */
        Pokemon pokemon = new Pokemon();
        pokemon.setDexNumber(1);
        pokemon.setPrimaryType("Grass");
        pokemon.setSecondaryType("Poison");

        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", "Grass", "Poison");
        Pokemon ivysaur = new Pokemon(2, "Ivysaur", "Grass", "Poison");
        Pokemon venusaur = new Pokemon(3, "Venusaur", "Grass", "Poison");

        System.out.println(venusaur.getPrimaryType());

        ivysaur.setName("Charmander");
        System.out.println(bulbasaur.getName());
        System.out.println(ivysaur.getName());
    }
}
