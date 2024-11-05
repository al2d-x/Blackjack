import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Dealer dealer;
    private ArrayList<Player> players;
    private CardStack deck;
    private Scanner scanner;

    public Game() {
        this.dealer = new Dealer("Steve the Dealer");
        this.players = new ArrayList<>();
        this.deck = new CardStack();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        setupPlayers();
        deck.shuffle();
        dealInitialCards();
        playerTurns();
        dealerTurn();
        displayResults();
        scanner.close();
    }

    // Setup players by creating the dealer and additional players
    private void setupPlayers() {
        players.add(dealer);
        PlayerInteraction.createPlayers(players, scanner);
    }

    // Deal initial two cards to each player
    private void dealInitialCards() {
        System.out.println("\nDealing initial cards...\n");
        for (Player player : players) {
            player.addCardToHand(deck.getCardStack().pop());
            player.addCardToHand(deck.getCardStack().pop());
            System.out.println(player.shortToString() + " | Hand Value: " + player.calculateHandValue());
        }
    }

    // Handle turns for all players except the dealer
    private void playerTurns() {
        for (Player player : players) {
            if (!player.equals(dealer)) {
                PlayerInteraction.playerTurn(player, deck, scanner);
            }
        }
    }

    // Dealer's turn
    private void dealerTurn() {
        dealer.playTurn(deck);
    }

    // Display final results and determine winners
    private void displayResults() {
        System.out.println("\nFinal Results:");
        int dealerHandValue = dealer.calculateHandValue();
        for (Player player : players) {
            int playerHandValue = player.calculateHandValue();
            System.out.print(player.getName() + " | Hand Value: " + playerHandValue);
            if (player.isBust()) {
                System.out.println(" - Bust! Dealer wins.");
            } else if (dealer.isBust() || playerHandValue > dealerHandValue) {
                System.out.println(" - Wins!");
                player.incrementWinCount();
            } else if (playerHandValue < dealerHandValue) {
                System.out.println(" - Loses.");
                player.incrementLoseCount();
            } else {
                System.out.println(" - Push (Tie).");
            }
        }
    }
}
