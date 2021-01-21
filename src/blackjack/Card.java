// Author: Justin Bashara
package blackjack;

public class Card {
    enum Suits {
        Clubs,
        Hearts,
        Diamonds,
        Spades;
    }
    
    enum Values {
        Two(2),
        Three(3),
        Four(4),
        Five(5),
        Six(6),
        Seven(7),
        Eight(8),
        Nine(9),
        Ten(10),
        Jack(10),
        Queen(10),
        King(10),
        Ace(11);
        
        // Assigning int values to the enum Values.
        protected int value;
        
        private Values(int value){
            this.value = value;
        }
        
        // Method for setting Ace value depending on the hand values.
        private void setAceValue(int value){
            Ace.value = value;
        }

    }
    
    private Suits suit;
    private Values value;
    
    
    public Card(Suits suit, Values value){
        this.suit = suit;
        this.value = value;
    }
    
    public String getSuit(){
        return suit.toString();
    }
    
    public String getValueName(){
        return value.toString();
    }
    
    public int getValue(){
        return this.value.value;
    }
    
    public Card changeAceValue(){
        // Changes an Ace's value from 11 to 1 and returns it.
        this.setAceValue();
        return this;
    }
    
    private void setAceValue(){
        this.value.setAceValue(1);
    }
}
