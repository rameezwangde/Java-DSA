package oops;

import java.util.Scanner;

class Game{
    public int number;
    public int noOfGuesses;

    public Game(){
        number=(int)(Math.random()*100)+1;
        noOfGuesses=0;
    }
    public int takeUserInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Guess the number:");
        int guess=sc.nextInt();
        noOfGuesses++;
        return guess;
    }
    public boolean isCorrectNumber(int guess){
        if(guess==number){
              System.out.println("🎉 Correct! You guessed it in " + noOfGuesses + " attempts.");
            return true;
        }else if(guess<number){
             System.out.println("Too low... try again!");
        }else{
            System.out.println("Too high... try again!");
        }
        return false;
    }
    public int getNoOfGuesses(){
        return noOfGuesses;
    }
    public void setNoOfGuesses(int noOfGuesses){
        this.noOfGuesses=noOfGuesses;
    }
}
public class Excercise3 {
    public static void main(String[] args) {
        /*
         Create a class game which allows a user to play "Guess the Number" game once
         Game should have the following methods:
         1.Constructor to generate the random number
         2.takeUserInput() to take a user input
         3.isCorrectNumber  to detect whether the number entered by the user is true
         Use properties such as noOfGuesses(int), etc to get this task done!
         4.getters nd setters for noOfGuesses
         */

         Game game=new Game();
        boolean isCorrect=false;

        while(!isCorrect){
            int userGuess=game.takeUserInput();
            isCorrect=game.isCorrectNumber(userGuess);
        }
        }
}
