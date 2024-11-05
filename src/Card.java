public class Card {
    private String suit;          // e.g., "Spades", "Hearts", "Diamonds", "Clubs"
    private String rank;          // e.g., "Ace", "2", "3", ..., "King"

    // Constructor
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getters and setters
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    // Method to return card description
    @Override
    public String toString() {
        // Since handValue is unknown, we pass 0 or another default here.
        int value = getBlackjackValueFromName(this.rank, 0);
        return "Card: " + rank + " of " + suit + " (Value: " + value + ")";
    }


    // Static method to get the blackjack value based on the card rank (no hand dependency)
    public static int getBlackjackValueFromName(String rank) {
        switch (rank) {
            case "Ace":
                return 11; // Default to 11, adjusted in Player class if needed
            case "King":
            case "Queen":
            case "Jack":
                return 10;
            default:
                return Integer.parseInt(rank); // Number cards return their own value
        }
    }
}
