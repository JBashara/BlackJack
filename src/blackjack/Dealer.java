// Author: Justin Bashara
package blackjack;

import java.util.*;

public class Dealer implements Hand{
    public List<Card> hand = new ArrayList<>();
    
    public Dealer(List<Card> hand){
        this.hand = hand;
    }
    
    @Override
    public void hit(Deck deck) {
        hand.add(deck.getCard());
    }

    @Override
    public int checkTotal(){
        int total = 0;
        
        for (Card card : hand) {
                total += card.getValue();
        }

        return total;
    }
    
    @Override
    public int isBust(){
        // Checks value of the dealer's hand.
        // Returns result as -1, 0, or 1 if total is less than, equal to, or greater than 21.
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
    public void showHand(){
        // Shows current hand
        System.out.println("Dealer's Hand:");
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
    
    public void showFirstCard(){
        // Shows one card "face up" and one card "face down" for the dealer.
        // This is used while it is the player's turn.
        System.out.println("Dealer's Hand:");
        System.out.println(hand.get(0).getValueName() + " of " + hand.get(0).getSuit());
        System.out.println("This Card Facedown.\n");
    }
}
