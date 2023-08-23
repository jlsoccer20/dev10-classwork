package learn.boardgames.models;

public class BoardGame {

    // identifier, internal value for us to keep track of, not to show to user
    private int id;

    private String title; // title of board game

    private int minimumPlayers;
    private int maximumPlayers;
    private String retailReleaseDate;
    private double rating;
    private boolean inCollection;
    private Availability availability;


    // Empty constructor
    public BoardGame(){

    }

    // Constructor
    public BoardGame(int id, String title, int minimumPlayers, int maximumPlayers,
                     String retailReleaseDate, double rating, boolean inCollection) {
        this.id = id;
        this.title = title;
        this.minimumPlayers = minimumPlayers;
        this.maximumPlayers = maximumPlayers;
        this.retailReleaseDate = retailReleaseDate;
        this.rating = rating;
        this.inCollection = inCollection;
    }

    public BoardGame(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public void setMinimumPlayers(int minimumPlayers) {
        this.minimumPlayers = minimumPlayers;
    }

    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    public void setMaximumPlayers(int maximumPlayers) {
        this.maximumPlayers = maximumPlayers;
    }

    public String getRetailReleaseDate() {
        return retailReleaseDate;
    }

    public void setRetailReleaseDate(String retailReleaseDate) {
        this.retailReleaseDate = retailReleaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isInCollection() {
        return inCollection;
    }

    public void setInCollection(boolean inCollection) {
        this.inCollection = inCollection;
    }
}
