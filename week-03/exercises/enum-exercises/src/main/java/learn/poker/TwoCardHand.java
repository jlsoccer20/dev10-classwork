package learn.poker;

import learn.cards.Card;

public class TwoCardHand implements Comparable<TwoCardHand> {

    private final Card high;
    private final Card low;

    public TwoCardHand(Card one, Card two) {
        if (one.compareTo(two) > 0) {
            this.high = one;
            this.low = two;
        } else {
            this.low = one;
            this.high = two;
        }
    }

    public Card getHigh() {
        return high;
    }

    public Card getLow() {
        return low;
    }

    public boolean isPair() {
        return high.getRank() == low.getRank();
    }

    @Override
    public int compareTo(TwoCardHand o) {
        // 1. Complete the compareTo method.
        // If the current TwoCardHand(`this`) has a lower score than the TwoCardHand parameter, compareTo returns
        // an int less than 0.
        // If `this` has a higher score than the TwoCardHand parameter, compareTo returns an int greater than 0.
        // If `this` and the TwoCardHand parameter have the same score, compareTo returns 0.
        // See Exercise04.md for scoring rules.

        if (this.isPair() == o.isPair()) {
            int highVsHigh = this.getHigh().compareTo(o.getHigh());
            int lowVsLow = this.getLow().compareTo(o.getLow());

            boolean highIsEqual = highVsHigh == 0;
            return highIsEqual ? lowVsLow : highVsHigh;
        }

        return this.isPair() ? 1 : -1;
    }
}

/*package learn.poker;

import learn.cards.Card;

public class TwoCardHand implements Comparable<TwoCardHand> {

    private final Card one;
    private final Card two;

    public TwoCardHand(Card one, Card two) {
        this.one = one;
        this.two = two;
    }

    public Card getOne() {
        return one;
    }

    public Card getTwo() {
        return two;
    }

    @Override
    public int compareTo(TwoCardHand hand) {
        // 1. Complete the compareTo method.
        // If the current TwoCardHand(`this`) has a lower score than the TwoCardHand parameter, compareTo returns
        // an int less than 0.
        // If `this` has a higher score than the TwoCardHand parameter, compareTo returns an int greater than 0.
        // If `this` and the TwoCardHand parameter have the same score, compareTo returns 0.
        // See Exercise04.md for scoring rules.
        boolean weHavePair = one.getRank() == two.getRank();
        boolean theyHavePair = hand.getOne().getRank() == hand.getTwo().getRank();

        if(weHavePair && theyHavePair) {
            return one.getRank().compareTo(hand.getOne().getRank());
        }else if (weHavePair && !theyHavePair){
            return 1; // we beat them
        } else if (!weHavePair && theyHavePair){
            return -1;
        }

        Card usHighCard;
        Card usLowCard;
        Card themHighCard;
        Card themLowCard;

        if(one.getRank().compareTo(two.getRank()) <0){
            usHighCard = two;
            usLowCard = one;
        } else {
            themHighCard = one;
            themLowCard = two;
        }
        int rankCompare = usHighCard.getRank().compareTo(themHighCard.getRank());
        if(rankCompare > 0 ){
            return 1;
        } else if(rankCompare < 0){
            return -1;

        }else{
            return usLowCard.getRank().compareTo(themLowCard.getRank());
        }
    }
}

 */
