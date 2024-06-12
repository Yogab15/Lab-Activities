package Practice;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame 
{
    // Enum to represent the possible choices
	//Enum def - when we want a variable to have only a specific set of values
    enum Choice 
    {
        ROCK, PAPER, SCISSORS;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Array of possible choices
        Choice[] choices = Choice.values();

        // Main game loop
        while (true)
        {
            System.out.println("Enter your choice (rock, paper, scissors). To exit the game, type 'exit':");
            String userInput = scanner.nextLine().toUpperCase();

            // Check if the user wants to exit
            if (userInput.equals("EXIT"))   //equals method-It checks if the characters in both strings are the same.
            {
                break;
            }

            // Validate user input
            Choice userChoice;
            try {
                userChoice = Choice.valueOf(userInput);
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            // Computer's random choice
            Choice computerChoice = choices[random.nextInt(choices.length)];

            // Display the choices
            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner using switch-case
            switch (userChoice) 
            {
                case ROCK:
                    switch (computerChoice)
                    {
                        case ROCK:
                            System.out.println("It's a tie!");
                            break;
                        case PAPER:
                            System.out.println("You lose! Paper covers Rock.");
                            break;
                        case SCISSORS:
                            System.out.println("You win! Rock crushes Scissors.");
                            break;
                    }
                    break;
                case PAPER:
                    switch (computerChoice)
                    {
                        case ROCK:
                            System.out.println("You win! Paper covers Rock.");
                            break;
                        case PAPER:
                            System.out.println("It's a tie!");
                            break;
                        case SCISSORS:
                            System.out.println("You lose! Scissors cut Paper.");
                            break;
                    }
                    break;
                case SCISSORS:
                    switch (computerChoice)
                    {
                        case ROCK:
                            System.out.println("You lose! Rock crushes Scissors.");
                            break;
                        case PAPER:
                            System.out.println("You win! Scissors cut Paper.");
                            break;
                        case SCISSORS:
                            System.out.println("It's a tie!");
                            break;
                    }
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
