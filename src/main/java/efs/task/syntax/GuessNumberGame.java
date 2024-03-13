package efs.task.syntax;

import java.util.Scanner;

public class GuessNumberGame {

    private int number;
    //Do not modify main method
    public static void main(String[] args) {
        try {
            GuessNumberGame game = new GuessNumberGame(args.length > 0 ? args[0] : "");
            game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GuessNumberGame(String argument) {
        try {
            number = Integer.parseInt(argument);
            if(number < 1  || number > UsefulConstants.MAX_UPPER_BOUND){
                throw new IllegalArgumentException();
            }
        }

        catch (NumberFormatException e) {
            System.out.println("'" + argument + "' to " + UsefulConstants.WRONG_ARGUMENT +  " - to nie liczba");
            System.exit(0);

        } catch (IllegalArgumentException e) {
            System.out.println(number + " to " + UsefulConstants.WRONG_ARGUMENT + " - jest spoza zakresu <1," + UsefulConstants.MAX_UPPER_BOUND + ">");
            System.exit(0);
        }
    }

    public void play() {
        System.out.println("Zagrajmy. Zgadnij liczbę z zakresu <1," + number + ">");
        int attempts = calculateAttempts(number);
        int guesses = 0;
        int numberToGuess = 1 + (int) (Math.random() * number);
        boolean didWin = false;
        Scanner sc = new Scanner(System.in);
        while( guesses < attempts ){
            printGuesses(guesses,attempts);
            guesses++;


            if(!sc.hasNextInt()){
                String userInput = sc.next();
                System.out.print("Hmm, "+userInput+" to "+UsefulConstants.NOT_A_NUMBER + "\n");
                continue;
            }

            int guess = sc.nextInt();

            if(guess < numberToGuess){
                System.out.print(UsefulConstants.TO_LESS + "\n");
            }
            else if(guess > numberToGuess){
                System.out.print(UsefulConstants.TO_MUCH + "\n");
            }
            else{
                System.out.print(UsefulConstants.YES + "\n");
                didWin = true;
                break;
            }
        }

        if(didWin){
            System.out.print(UsefulConstants.CONGRATULATIONS +guesses+" - tyle prób zajęło Ci odgadnięcie liczby "+number);
        }
        else{
            System.out.print(UsefulConstants.UNFORTUNATELY + "wyczerpałeś limit prób ("+attempts+") do odgadnięcia liczby " + number);
        }

    }

    private int calculateAttempts(int number){
        return  Math.abs((int)(Math.log(number) / Math.log(2))) + 1;
        // Rzutuję to do int czyli tracę część ułamkową, (nie było sprecyzowane w poleceniu).
    }

    private void printGuesses(int guesses,int attempts){
        int stars = guesses+1;
        int dots = attempts - stars;
        System.out.print("Twoje próby: [");
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < dots; i++) {
            System.out.print(".");
        }
        System.out.println("]\n"+ UsefulConstants.GIVE_ME );
    }



}
