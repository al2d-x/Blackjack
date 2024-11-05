import java.util.ArrayList;
import java.util.Scanner;

public class PlayerInteraction {
    // Create players based on user input
    public static void createPlayers(ArrayList<Player> players, Scanner scanner) {
        System.out.println("Would you like to create a player? (yes/no)");
        while (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter player's name: ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));

            System.out.println("Would you like to create another player? (yes/no)");
        }
    }

    // Manage a player's turn
    public static void playerTurn(Player player, CardStack deck, Scanner scanner) {
        System.out.println("\n" + player.getName() + "'s turn:");
        while (true) {
            System.out.print("Would you like to hit or stand? (hit/stand): ");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("hit")) {
                Card drawnCard = deck.getCardStack().pop();
                player.addCardToHand(drawnCard);
                System.out.println("Drew " + drawnCard + " | New Hand Value: " + player.calculateHandValue());

                if (player.isBust()) {
                    System.out.println(player.getName() + " busts!");
                    break;
                }
            } else if (decision.equalsIgnoreCase("stand")) {
                System.out.println(player.getName() + " stands with hand value: " + player.calculateHandValue());
                break;
            } else {
                System.out.println("Invalid choice. Please choose 'hit' or 'stand'.");
            }
        }
    }
}
