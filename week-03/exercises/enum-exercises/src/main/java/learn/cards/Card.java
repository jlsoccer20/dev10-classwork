package learn.cards;

public class Card {

    private final Suit suit;
    private final Rank rank;

    // 1. Add a Suit and Rank field to the Card class.
    //Rank rank = Rank.QUEEN;
    //Suit suit = Suit.HEARTS;

    // 2. Add a constructor that accepts a Suit and Rank and sets the appropriate fields.

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // 3. Add getters for both suit and rank.
    public Suit getSuit(){
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String getName() {

        // 4. Complete the getName method.
        // Given a card's suit and rank, getName returns a String in the format:
        // "[rank] of [suit]"

        // Examples:
        // Ace of Clubs
        // 5 of Diamonds
        // King of Hearts
        // 9 of Spades
        return String.format("", rank.getName(), suit.getName());
        /*
        String strSuit = switch(suit){
            case DIAMONDS -> "Diamond";
            case CLUBS -> "Clubs";
        }

         */

        // Note: it's unlikely you'll be able to use the enum name directly since enum naming conventions
        // don't match the required output.
        return null;
    }

    public int compareTo(Card two) {
    }
}
