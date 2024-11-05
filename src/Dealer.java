public class Dealer extends Player {
    public Dealer(String name) {
        super(name);
    }

    // Dealer-specific turn behavior
    public void playTurn(CardStack deck) {
        System.out.println("\n" + getName() + "'s turn:");
        while (calculateHandValue() < 17) {
            Card drawnCard = deck.getCardStack().pop();
            addCardToHand(drawnCard);
            System.out.println(getName() + " drew " + drawnCard + " | New Hand Value: " + calculateHandValue());
        }

        if (isBust()) {
            System.out.println(getName() + " busts!");
        } else {
            System.out.println(getName() + " stands with hand value: " + calculateHandValue());
        }
    }
}
