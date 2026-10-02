// This class represents the submission system
// It allows the users to submit content and admins approve it

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Submission {

    private String title;          // submission title
    private String type;           // submission type
    private String story;          // upload a story
    private boolean approved;      // approval status


    // add parameters to the constructors
    public Submission() {

        title = "";
        type = "";
        story = "";
        approved = false;
    }

    // submit a story or a resource
    public void submitResource(java.util.Scanner input) {


        System.out.println("\n=====================================");
        System.out.println("          RESOURCE SUBMISSION          ");
        System.out.println("========================================");

        System.out.println("Enter a title: ");
        title = input.nextLine();

        if (title.trim().isEmpty()) {
            System.out.println("Title cannot be empty. ");
            return;
        }

        System.out.println("Enter the resource type: ");
        type = input.nextLine();

        if (type.trim().isEmpty()) {
            System.out.println("Resource type cannot be empty. ");
            return;
        }
        System.out.println("Enter your story or information (10-200 characters): ");

        story = input.nextLine();


        if (story.length() < 10 || story.length() > 200) {
            System.out.println("Your submission must be between 10 and 200 characters.");
            return;
        }

        saveSubmission();

        System.out.println("Submission saved successfully for review.");
    }

    // save submission to a text file
    private void saveSubmission() {
        try {
            FileWriter file = new FileWriter("Submission.txt", true);

            file.write("Title:" + title + "\n");
            file.write("Type: " + type + "\n");
            file.write("Story: " + story + "\n");
            file.write("Approved: " + approved + "\n");
            file.write("--------------------------------------------\n");

            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the submission");
        }
    }

    public void approve() {
        approved = true;

        System.out.println("Submission approved.");
    }

    public void reject() {
        approved = false;
        System.out.println("Submission rejected.");
    }

    public boolean isApproved() {
        return approved;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getStory() {
        return story;
    }
}
