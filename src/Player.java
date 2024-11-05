import java.util.ArrayList;

public class Player {
    private String name;
    private int winCount;
    private int loseCount;
    private ArrayList<Card> cardHand;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.winCount = 0;
        this.loseCount = 0;
        this.cardHand = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public ArrayList<Card> getCardHand() {
        return cardHand;
    }

    // Method to add a card to the player's hand
    public void addCardToHand(Card card) {
        cardHand.add(card);
    }

    // Method to clear the player's hand (e.g., for a new round)
    public void clearHand() {
        cardHand.clear();
    }

    // Method to calculate the total value of the player's hand in Blackjack
    public int calculateHandValue() {
        int totalValue = 0;
        int aceCount = 0;

        for (Card card : cardHand) {
            int cardValue = Card.getBlackjackValueFromName(card.getRank(), totalValue);
            totalValue += cardValue;
            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }

        // Adjust for Aces if totalValue exceeds 21
        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10;  // Convert an Ace from 11 to 1
            aceCount--;
        }

        return totalValue;
    }

    // Method to check if the player has gone bust
    public boolean isBust() {
        return calculateHandValue() > 21;
    }

    // Method to check for Blackjack
    public boolean hasBlackjack() {
        return cardHand.size() == 2 && calculateHandValue() == 21;
    }

    // Methods to increment win/lose count
    public void incrementWinCount() {
        winCount++;
    }

    public void incrementLoseCount() {
        loseCount++;
    }

    @Override
    public String toString() {
        return "Player: " + name + " | Wins: " + winCount + " | Losses: " + loseCount + " | Hand: " + cardHand;
    }
}
