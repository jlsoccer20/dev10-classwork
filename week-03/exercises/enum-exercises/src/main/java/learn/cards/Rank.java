package learn.cards;

public enum Rank {

    ACE(14,"Ace"),
    TWO(2,"2"),
    THREE(3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"10"),
    JACK(11,"Jack"),
    QUEEN(12,"Queen"),
    KING(13,"King");

    private String name;
    Rank (int rank, String name){
        this.name = name;
        this.rank = rank;
    }

    String getName() {
        return name;
    }
    /*
    public static void main(String[] args) {
        Rank ace = Rank.ACE;
        Rank card2 = Rank.TWO;
        Rank card3 = Rank.THREE;
        Rank card4 = Rank.FOUR;
        Rank card5 = Rank.FIVE;
        Rank card6 = Rank.SIX;
        Rank card7 = Rank.SEVEN;
        Rank card8 = Rank.EIGHT;
        Rank card9 = Rank.NINE;
        Rank card10 = Rank.TEN;
        Rank jack = Rank.JACK;
        Rank queen = Rank.QUEEN;
        Rank king = Rank.KING;

        System.out.println(card2);
    }
    */

}
