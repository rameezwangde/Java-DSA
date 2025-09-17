package oops;

import java.util.Scanner;

class RPSGame {
    private String computerChoice;
    private int noOfRounds;

    public RPSGame() {
        computerChoice = generateChoice();
        noOfRounds = 0;
    }

    private String generateChoice() {
        int rand = (int)(Math.random() * 3);
        if (rand == 0) return "rock";
        else if (rand == 1) return "paper";
        else return "scissors";
    }

    public String takeUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice (rock, paper, scissors): ");
        String userChoice = sc.next().toLowerCase();
        noOfRounds++;
        return userChoice;
    }

    public boolean decideWinner(String userChoice) {
        System.out.println("Computer chose: " + computerChoice);

        if (userChoice.equals(computerChoice)) {
            System.out.println("It’s a draw!");
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            System.out.println("🎉 You win!");
            return true;
        } else {
            System.out.println("💻 Computer wins!");
        }
        return false;
    }

    public int getNoOfRounds() {
        return noOfRounds;
    }

    public void setNoOfRounds(int noOfRounds) {
        this.noOfRounds = noOfRounds;
    }
}

public class Excercise4 {
    public static void main(String[] args) {
        RPSGame game = new RPSGame();
        String userChoice = game.takeUserInput();
        game.decideWinner(userChoice);
        System.out.println("Rounds played: " + game.getNoOfRounds());
    }
}

