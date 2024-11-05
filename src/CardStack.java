import java.util.Collections;
import java.util.Stack;

public class CardStack {
    private Stack<Card> cardStack;

    public CardStack() {
        cardStack = new Stack<>();
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        // Loop through each suit and rank to generate the deck
        for (String suit : suits) {
            for (String rank : ranks) {
                cardStack.push(new Card(suit, rank));
            }
        }
    }

    // Method to get the card stack
    public Stack<Card> getCardStack() {
        return cardStack;
    }

    // Method to shuffle the card stack
    public void shuffle() {
        Collections.shuffle(cardStack);
    }

}
