package efs.task.syntax;

public class GuessNumberGame {

    private int number;
    private int attempts;
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
            System.exit(1);

        } catch (IllegalArgumentException e) {
            System.out.println(number + " to " + UsefulConstants.NOT_A_NUMBER + " - jest spoza zakresu <1," + UsefulConstants.MAX_UPPER_BOUND + ">");
            System.exit(1);
        }
    }

    public void play() {
        System.out.println("Zagrajmy. Zgadnij liczbę z zakresu <1," + number + ">");
        attempts = calculateAttempts(number);
    }

    private int calculateAttempts(int number){
        int attempts = Math.abs((int)(Math.log(number) / Math.log(2))) + 1;
        // Rzutuję to do int czyli tracę część ułamkową, (nie było sprecyzowane w poleceniu).
        return attempts;
    }

    private void printGuesses(int Guesses){
        int dots = att
        System.out.println();
    }


}
