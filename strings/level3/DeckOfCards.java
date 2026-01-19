import java.util.Scanner;

/*
 * Program to initialize, shuffle, and distribute a deck of cards to players
 */
public class DeckOfCards {

    public static String[] initializeDeck() {
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] deck = new String[suits.length * ranks.length];
        
        int idx = 0;
        // Nested loop to combine each rank with each suit
        for (String r : ranks) {
            for (String s : suits) {
                deck[idx++] = r + " of " + s;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        // Iterate through the deck to swap each card with a random one
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            // Perform swap
            String tmp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = tmp;
        }
        return deck;
    }

    public static String[][] distribute(String[] deck, int numPlayers, int cardsEach) {
        // Validate if there are enough cards
        if (numPlayers * cardsEach > deck.length) return null;
        
        String[][] out = new String[numPlayers][cardsEach];
        int idx = 0;
        
        // Loop to distribute cards one by one (or in chunks as logic dictates)
        for (int c = 0; c < cardsEach; c++) {
            for (int p = 0; p < numPlayers; p++) {
                out[p][c] = deck[idx++];
            }
        }
        return out;
    }

    public static void printPlayers(String[][] players) {
        // Loop to display each player's hand
        for (int p = 0; p < players.length; p++) {
            System.out.println("Player " + (p+1) + ": " + java.util.Arrays.toString(players[p]));
        }
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            // Create a standard deck
            String[] deck = initializeDeck();
            
            // Shuffle the deck
            deck = shuffleDeck(deck);
            
            System.out.print("Number of players: ");
            int players = sc.nextInt();
            System.out.print("Cards each: ");
            int each = sc.nextInt();
            
            // Distribute cards
            String[][] dealt = distribute(deck, players, each);
            
            if (dealt == null) {
                System.out.println("Cannot distribute");
            } else {
                printPlayers(dealt);
            }
        }
    }
}
