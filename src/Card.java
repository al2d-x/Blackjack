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


    // Static method to get the blackjack value based on the card name
    public static int getBlackjackValueFromName(String name, int handValue) {
        switch (name) {
            case "Ace":
                if (handValue + 11 < 22) {
                return 11;
                } else {
                    return 1;
                }
            case "King":
            case "Queen":
            case "Jack":
                return 10;
            default:
                return Integer.parseInt(name); // Number cards return their own value
        }
    }
}
