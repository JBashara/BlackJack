// Author: Justin Bashara
package blackjack;

public interface Hand {
    public void hit(Deck deck);
    public int checkTotal();
    public int isBust();
    public void showHand();
}
