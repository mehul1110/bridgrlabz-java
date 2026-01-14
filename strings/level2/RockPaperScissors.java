import java.util.Scanner;

public class RockPaperScissors {
    public static String compChoice() {
        int r = (int)(Math.random() * 3);
        return r==0?"rock":r==1?"paper":"scissors";
    }

    public static String winner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if (user.equals("rock") && comp.equals("scissors") ||
            user.equals("scissors") && comp.equals("paper") ||
            user.equals("paper") && comp.equals("rock")) return "User";
        return "Computer";
    }

    public static String[][] statsTable(java.util.List<String[]> games, int userWins, int compWins, int draws) {
        int n = games.size();
        String[][] out = new String[n+1][4];
        for (int i = 0; i < n; i++) {
            out[i][0] = String.valueOf(i+1);
            out[i][1] = games.get(i)[0];
            out[i][2] = games.get(i)[1];
            out[i][3] = games.get(i)[2];
        }
        out[n][0] = "Total";
        out[n][1] = "UserWins:" + userWins;
        out[n][2] = "CompWins:" + compWins;
        out[n][3] = "Draws:" + draws;
        return out;
    }

    public static void display(String[][] table) {
        System.out.printf("%-6s %-8s %-10s %s%n", "Game", "User", "Computer", "Winner");
        for (String[] r : table) System.out.printf("%-6s %-8s %-10s %s%n", r[0], r[1], r[2], r[3]);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of games: ");
            int n = sc.nextInt();
            int userWins = 0, compWins = 0, draws = 0;
            java.util.List<String[]> games = new java.util.ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.print("Enter choice (rock/paper/scissors): ");
                String user = sc.next().toLowerCase();
                String comp = compChoice();
                String win = winner(user, comp);
                if (win.equals("User")) userWins++; else if (win.equals("Computer")) compWins++; else draws++;
                games.add(new String[]{user, comp, win});
            }
            String[][] table = statsTable(games, userWins, compWins, draws);
            display(table);
            double total = n > 0 ? n : 1;
            System.out.printf("User win %%: %.2f%%\n", userWins*100.0/total);
            System.out.printf("Computer win %%: %.2f%%\n", compWins*100.0/total);
        }
    }
}
