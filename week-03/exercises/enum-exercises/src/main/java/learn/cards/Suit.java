package learn.cards;

public enum Suit {
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades"),
    CLUBS("Clubs");

    private String name;
    Suit(String name){
        this.name = name;
    }

    String getName() {
        return name;
    }
    /*public static void main(String[] args) {
        Suit suit1 = Suit.DIAMONDS;
        Suit suit2 = Suit.HEARTS;
        Suit suit3 = Suit.SPADES;
        Suit suit4 = Suit.CLUBS;

        System.out.println(suit1);
    }*/
}





