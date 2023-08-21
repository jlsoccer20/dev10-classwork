package learn.cards;

public enum Rank {

    ACE, TWO(2), THREE, "4", "5", "6", "7", "8", "9", "10", JACK, QUEEN, KING;
    public static void main(String[] args) {
        Rank ace = Rank.ACE;
        Rank card1 = Rank.JACK;
        Rank queen = Rank.QUEEN;
        Rank king = Rank.KING;

        System.out.println(card1);
    }
}
