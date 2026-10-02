// This Java program demonstrates how the system works based on OOP Principles.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // create main objects used by the system
        ResourceLibrary library = new ResourceLibrary();
        Quiz quiz = new Quiz();
        Submission submission = new Submission();

        // Add resources into the library
        library.addResource(new Resource("What is Drink Spiking?", "PDF", "spiking", "Awareness Team", "Information about drink spiking and recognising potential risks." ));
        library.addResource(new Resource("Recognising the Signs of Spiking", "PDF", "signs", "Awareness Team", "Information about recognising possible signs of drink spiking."));
        library.addResource(new Resource("Student Awareness Campaign", "Story", "awareness", "Awareness Team", "A resource promoting student awareness of drink spiking."));
        library.addResource(new Resource("How to Stay safe in Public", "Video", "safety", "Awareness Team", "Guidance on personal safety in public places."));
        library.addResource(new Resource("Night out Safety Guide", "PDF", "guide", "Awareness Team", "Practical advice for staying safe on a night out."));
        library.addResource(new Resource("Real Student Experience", "Story", "experience", "Student Contributor,", "A student experience shared to support awareness."));

        int choice = 0;

        // Main menu loop repeats until user exits
        while (choice != 5) {

            System.out.println("\n========================================");
            System.out.println("-----------SPIKE AWARENESS SYSTEM---------");
            System.out.println("1. View all Resources");
            System.out.println("2. Search Resources");
            System.out.println("3. Take the Awareness Quiz");
            System.out.println("4. Submit a resource or story");
            System.out.println("5. Exit");
            System.out.println("==========================================");

            System.out.println("Choose an option: ");

            // check that the user has entered a number
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        library.displayResources();

                    case 2:
                        System.out.println("Enter a keyword to search: ");
                        String searchTerm = input.nextLine();

                        library.searchResource(searchTerm);
                        break;

                    case 3:
                        quiz.startQuiz();
                        break;

                    case 4:
                        submission.submitResource(input);
                        break;

                    case 5:
                        System.out.println("Thank you for using the Spike Awareness System.");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose between 1 and 5.");

                }
            } else {
                System.out.println("Invalid input. Please enter a number5.");

                input.nextLine();
            }
        }

        input.close();
    }
}
