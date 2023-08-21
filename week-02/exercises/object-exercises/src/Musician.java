public class Musician {

    private String name;
    private int rating;

    // Constructor
    public Musician(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating(){
        return this.rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @param name   The name of the musician.
     * @param rating A number representing how much a musician is loved relative to other musicians.
     */
    public Musician(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {

        return name;
    }


}
