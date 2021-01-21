// Author: Justin Bashara
package blackjack;

import blackjack.Card.Suits;
import blackjack.Card.Values;
import java.util.*;

public class Deck {
    //private Card card;
    private List<Card> deck = new ArrayList<>(52);

    
    public Deck(){
        // Adding Cards to the deck.
        for (Suits suit : Suits.values()) {
            for (Values value : Values.values()) {
                Card c = new Card(suit,value);
                deck.add(c);
            }
        }    
    }  
    
    public List<Card> deal(){
        // Deals initial cards to player and dealer.
        // Adds cards to player and dealer hands.
        List<Card> hand = new ArrayList<>(2);
        
        hand.add(deck.get(0));
        deck.remove(0);
        hand.add(deck.get(0));
        deck.remove(0);

        return hand;
        
    }
    
    public void shuffle(){
        Collections.shuffle(this.deck);
    }
    
    public Card getCard(){
        // Returns one card from the deck and removes it from deck.
        // Called by hit method from player or dealer class.
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public int getSize(){
        return deck.size();
    }
    
}
