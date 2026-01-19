import java.util.Scanner;

/*
 * Program to simulate Rock-Paper-Scissors game
 */
public class RockPaperScissors {

    public static String compChoice() {
        // Generate a random integer 0, 1, or 2 to represent choice
        int r = (int)(Math.random() * 3);
        // Map integer to Rock, Paper, or Scissors string
        return r == 0 ? "rock" : r == 1 ? "paper" : "scissors";
    }

    public static String winner(String user, String comp) {
        // Check for a draw condition
        if (user.equals(comp)) return "Draw";
        
        // Logic to determine winner based on game rules:
        // Rock beats Scissors, Scissors beats Paper, Paper beats Rock
        if (user.equals("rock") && comp.equals("scissors") ||
            user.equals("scissors") && comp.equals("paper") ||
            user.equals("paper") && comp.equals("rock")) {
            return "User";
        }
        // If not draw and user didn't win, Computer wins
        return "Computer";
    }

    public static String[][] statsTable(java.util.List<String[]> games, int userWins, int compWins, int draws) {
        int n = games.size();
        String[][] out = new String[n+1][4];
        
        // Loop through recorded games to populate the stats table
        for (int i = 0; i < n; i++) {
            out[i][0] = String.valueOf(i+1);       // Game Number
            out[i][1] = games.get(i)[0];           // User Choice
            out[i][2] = games.get(i)[1];           // Computer Choice
            out[i][3] = games.get(i)[2];           // Winner
        }
        
        // Add a row for overall summary statistics at the end
        out[n][0] = "Total";
        out[n][1] = "UserWins:" + userWins;
        out[n][2] = "CompWins:" + compWins;
        out[n][3] = "Draws:" + draws;
        return out;
    }

    public static void display(String[][] table) {
        System.out.printf("%-6s %-8s %-10s %s%n", "Game", "User", "Computer", "Winner");
        // Loop through table rows to display game history
        for (String[] r : table) System.out.printf("%-6s %-8s %-10s %s%n", r[0], r[1], r[2], r[3]);
    }

    public static void main(String[] args) {
        // Initialize Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of games: ");
            int n = sc.nextInt();
            int userWins = 0, compWins = 0, draws = 0;
            java.util.List<String[]> games = new java.util.ArrayList<>();
            
            // Game Loop: runs 'n' times for user interactions
            for (int i = 0; i < n; i++) {
                System.out.print("Enter choice (rock/paper/scissors): ");
                String user = sc.next().toLowerCase();
                String comp = compChoice();
                String win = winner(user, comp);
                
                // Update win counters
                if (win.equals("User")) userWins++; 
                else if (win.equals("Computer")) compWins++; 
                else draws++;
                
                // Store game result
                games.add(new String[]{user, comp, win});
            }
            
            // Generate and display statistics table
            String[][] table = statsTable(games, userWins, compWins, draws);
            display(table);
            
            // Calculate and display win percentages
            double total = n > 0 ? n : 1;
            System.out.printf("User win %%: %.2f%%\n", userWins * 100.0 / total);
            System.out.printf("Computer win %%: %.2f%%\n", compWins * 100.0 / total);
        }
    }
}
