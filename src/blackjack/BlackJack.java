// Author: Justin Bashara
package blackjack;

import java.util.*;

public class BlackJack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("Press S to start a new game or any other key to quit.");
        input = scan.nextLine();

        while (input.equals("S") || input.equals("s")) {
            Deck deck = new Deck();
            deck.shuffle();
            Player player = new Player(deck.deal());
            Dealer dealer = new Dealer(deck.deal());
            player.showHand();
            dealer.showFirstCard();

            if (player.isBust() == 0 && dealer.isBust() != 0) {
                System.out.println("You win.");
            } 
            else if (dealer.isBust() == 0 && player.isBust() !=0) {
                dealer.showHand();
                System.out.println("Dealer wins.");
            }
            else {
                // This loop is the player's turn.
                do {
                    System.out.println("Enter \"hit\" or \"stand\".");
                    input = scan.nextLine();

                    if (input.equals("hit")) {
                        player.hit(deck);
                        if(player.isBust() > 1) break;
                        else {
                            player.showHand();
                            dealer.showFirstCard();
                        }
                    } else if (input.equals("stand")) {
                        break;
                    } else {
                        System.out.println("\nEnter \"hit\" or \"stand\".");
                    }
                } while (player.isBust() == -1);
                
                switch (player.isBust()) {
                    case 1:
                        System.out.println("Dealer wins.\n");
                        break;
                    case 0:
                        System.out.println("You win.\n");
                        break;
                    default:
                        // This if-else and loop is the dealer's turn.
                        dealer.showHand();
                        while(dealer.checkTotal() < 17){
                            dealer.hit(deck);
                            player.showHand();
                            dealer.showHand();
                            if(dealer.isBust() > 1) break; 
                        }   if(dealer.isBust() == 1){
                            System.out.println("You win.\n");
                        }
                        else if(player.checkTotal() > dealer.checkTotal()){
                            System.out.println("You win.\n");
                        }
                        else if(player.checkTotal() == dealer.checkTotal()){
                            System.out.println("Push.\n");
                        }
                        else System.out.println("Dealer wins.\n");
                        break;
                }
            }
            
            System.out.println("Would you like to play again?"
                        + " Enter S for a new game or any other key to quit.");
            input = scan.nextLine();

        } 
        
        System.out.println("Thanks for playing!");

    }
}
