package learn.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    // 1. Instantiate cards with the appropriate suit and rank for each test.
    // 2. Run the tests and confirm they pass. Do NOT change existing assertions.
    // 3. Add a couple more tests to confirm everything is working as intended.

    @Test
    void shouldNameTwoOfHearts() {
        // TODO: instantiate Card with arguments.
        Card card = new Card(Rank.TWO, Suit.HEARTS);
        assertEquals("2 of Hearts", card.getName());
    }

    @Test
    void shouldNameQueenOfDiamonds() {
        // TODO: instantiate Card with arguments.
        Card card = new Card(Rank.QUEEN, Suit.DIAMONDS);
        assertEquals("Queen of Diamonds", card.getName());
    }

    @Test
    void shouldNameTenOfClubs() {
        // TODO: instantiate Card with arguments.
        Card card = new Card(Rank.TEN, Suit.CLUBS);
        assertEquals("10 of Clubs", card.getName());
    }

    @Test
    void shouldNameAceOfSpades() {
        // TODO: instantiate Card with arguments.
        Card card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals("Ace of Spades", card.getName());
    }

    @Test
    void shouldNameJackOfHearts() {
        // TODO: instantiate Card with arguments.
        Card card = new Card(Rank.JACK, Suit.HEARTS);
        assertEquals("Jack of Hearts", card.getName());
    }

    @Test
    void shouldNameQueenOfHearts() {
        // TODO: instantiate Card with arguments.
        Card card = new Card(Rank.QUEEN, Suit.HEARTS);
        assertEquals("Queen of Hearts", card.getName());
    }
}