// Author: Justin Bashara
package blackjack;

import java.util.*;

public class Player implements Hand {

    public List<Card> hand = new ArrayList<>();

    public Player(List<Card> hand) {
        this.hand = hand;
    }

    @Override
    public void hit(Deck deck) {
        hand.add(deck.getCard());
    }

    @Override
   public int checkTotal() {
        // Totals the value of player's hand.
        int total = 0;
        
        for (Card card : hand) {
                total += card.getValue();
        }

        return total;
    }

    @Override
    public int isBust() {
        // Checks value of players hand and see if they have gone bust.
        int result = -1;
        int total = this.checkTotal();
        
        if (total > 21) {
            result = 1;
            for(Card c : this.hand){
                if(c.getValue() == 11){
                    c.changeAceValue();
                }
            }
        } 
        else if (total == 21) {
            result = 0;
        }

        return result;
    }

    @Override
    public void showHand() {
        // Shows current hand
        System.out.println("\nYour Hand:");
        for (Card card : hand) {
            System.out.println(card.getValueName() + " of " + card.getSuit());
        }
        int total = 0;
        for(Card card : hand){
            total += card.getValue();
        }
        System.out.println(total);
        System.out.print("\n");
    }

}
